package com.shakalinux.app.controller;

import com.shakalinux.app.model.Acess;
import com.shakalinux.app.model.Profile;
import com.shakalinux.app.model.ReadingProgress;
import com.shakalinux.app.model.User;
import com.shakalinux.app.service.AcessService;
import com.shakalinux.app.service.ProfileService;
import com.shakalinux.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private AcessService acessService;

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User user = userService.findUserByEmail(email);
        if (user == null) {
            return "redirect:/users/login";
        }

        Profile profile = user.getProfile();
        if (profile == null) {
            profile = new Profile();
            profile.setUser(user);
            profile.setNickname(user.getFullname());
            profileService.saveProfile(profile);
            user.setProfile(profile);
            userService.saveUser(user);
        }


        List<Acess> acesses = acessService.acessesUsers(user);
        Set<LocalDate> diasAcessados = new HashSet<>();
        for (Acess acesso : acesses) {
            diasAcessados.add(acesso.getDataAcesso());
        }
        model.addAttribute("diasAcessados", diasAcessados.size());


        if (profile.getImageProfile() != null && profile.getImageProfile().length > 0) {
            String avatarBase64 = Base64.getEncoder().encodeToString(profile.getImageProfile());
            profile.setImageAvatar64(avatarBase64);
        }


        if (profile.getImagesection() != null && profile.getImagesection().length > 0) {
            String sectionBase64 = Base64.getEncoder().encodeToString(profile.getImagesection());
            profile.setImagesection64(sectionBase64);
        }


        int totalBooks = 0;
        int booksCompleted = 0;
        int booksInProgress = 0;
        int booksNotStarted = 0;

        if (profile.getReadingProgresses() != null) {
            totalBooks = profile.getReadingProgresses().size();
            for (ReadingProgress progress : profile.getReadingProgresses()) {
                if (progress.getReadPercentage() != null && progress.getReadPercentage() >= 100.0) {
                    booksCompleted++;
                } else if (progress.getStartDate() != null && (progress.getReadPercentage() == null || progress.getReadPercentage() < 100.0)) {
                    booksInProgress++;
                } else {
                    booksNotStarted++;
                }
            }
        }

        model.addAttribute("totalBooksReadProgress", totalBooks);
        model.addAttribute("booksCompleted", booksCompleted);
        model.addAttribute("booksInProgress", booksInProgress);
        model.addAttribute("booksNotStarted", booksNotStarted);
        model.addAttribute("user", user);
        model.addAttribute("profile", profile);

        return "profile/profile";
    }

    @PostMapping("/updateText")
    public String updateProfileText(@ModelAttribute("profile") @Valid Profile profile, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.findUserByEmail(email);

        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Usuário não encontrado.");
            return "redirect:/profiles";
        }

        Profile existingProfile = profileService.findByUser(user);
        if (existingProfile == null) {
            redirectAttributes.addFlashAttribute("error", "Perfil não encontrado.");
            return "redirect:/profiles";
        }

        profile.setIdProfile(existingProfile.getIdProfile());

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.profile", bindingResult);
            redirectAttributes.addFlashAttribute("profile", profile);
            redirectAttributes.addFlashAttribute("error", "Erro ao atualizar perfil. Verifique os campos.");
            return "redirect:/profiles";
        }

        try {
            existingProfile.setNickname(profile.getNickname());
            existingProfile.setSummary(profile.getSummary());
            existingProfile.setVerse(profile.getVerse());
            profileService.saveProfile(existingProfile);
            redirectAttributes.addFlashAttribute("success", "Dados do perfil atualizados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Erro ao salvar os dados do perfil: " + e.getMessage());
        }

        return "redirect:/profiles";
    }

    @PostMapping("/updateImages")
    public String updateProfileImages(@ModelAttribute("profile") Profile profile, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.findUserByEmail(email);

        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Usuário não encontrado.");
            return "redirect:/profiles";
        }

        Profile existingProfile = profileService.findByUser(user);
        if (existingProfile == null) {
            redirectAttributes.addFlashAttribute("error", "Perfil não encontrado.");
            return "redirect:/profiles";
        }

        try {
            if (profile.getImageAvatar() != null && !profile.getImageAvatar().isEmpty()) {
                existingProfile.setImageProfile(profile.getImageAvatar().getBytes());
            }

            if (profile.getImageSecFile() != null && !profile.getImageSecFile().isEmpty()) {
                existingProfile.setImagesection(profile.getImageSecFile().getBytes());
            }

            profileService.saveProfile(existingProfile);
            redirectAttributes.addFlashAttribute("success", "Imagens do perfil atualizadas com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Erro ao fazer upload da imagem: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Erro ao salvar as imagens do perfil: " + e.getMessage());
        }

        return "redirect:/profiles";
    }
}
