package com.shakalinux.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bible_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, length = 10)
    private String abbreviation;

    @Column(nullable = false)
    private String testament;

    @Column(name = "number_of_chapters")
    private Integer numberOfChapters;

    private String author;

    @Column(length = 1000)
    private String historicalContext;

    @Column(length = 500)
    private String theme;

    private String genre;

    @Column(name = "order_in_testament")
    private Integer orderInTestament;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(length = 2000)
    private String keyVerses;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReadingProgress> readingProgresses = new ArrayList<>();
}