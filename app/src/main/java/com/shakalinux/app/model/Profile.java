package com.shakalinux.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfile;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    @Size(min = 1, max = 45, message = "Nome deve conter entre 1 a 45 caracteres")
    private String nickname;

    @Column( columnDefinition = "LONGTEXT")
    private String summary;

    private String verse;

    @Lob
    private byte[] imageProfile;

    @Lob
    private byte[] imagesection;

    @Transient
    private MultipartFile imageAvatar;

    @Transient
    private MultipartFile imageSecFile;

    @Transient
    private String imageAvatar64;

    @Transient
    private String imagesection64;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReadingProgress> readingProgresses = new ArrayList<>();
}