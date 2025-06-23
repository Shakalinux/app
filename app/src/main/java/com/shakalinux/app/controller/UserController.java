package com.shakalinux.app.controller;

import com.shakalinux.app.model.Profile;
import com.shakalinux.app.model.User;
import com.shakalinux.app.service.ProfileService;
import com.shakalinux.app.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("user", new User());
        return "Users/cadastro";
    }

    @PostMapping("/cadastro")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {

            model.addAttribute("erros", result.getAllErrors());
            return "Users/cadastro";
        } else {

            if (userService.findUserByEmail(user.getEmail()) != null) {
                model.addAttribute("erros", new ValidationException("O email " + user.getEmail() + " é inválido."));
                return "Users/cadastro";
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Profile profile = new Profile();
            profile.setNickname(user.getFullname());
            profile.setUser(user);
            profileService.saveProfile(profile);
            user.setProfile(profile);
            userService.saveUser(user);

            model.addAttribute("message", "Usuário cadastrado com sucesso! Faça login para continuar.");
            return "redirect:/users/login";
        }
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "Users/login";
    }



    @PostMapping("/login")
    public String loginUser(@ModelAttribute @Validated User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            return "Users/login";
        }

        User existingUser = userService.findUserByEmail(user.getEmail());


        if (existingUser == null || !passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            model.addAttribute("error", "Email ou senha inválidos. Tente novamente ou cadastre-se!");
            return "Users/login";
        }

        return "redirect:/profiles";
    }
}