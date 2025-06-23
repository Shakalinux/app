package com.shakalinux.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Verse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVerse;

    @ManyToOne
    @JoinColumn(name = "idChapter", nullable = false)
    private Chapter chapter;


    @Column(name = "verse_number", nullable = false)
    private Integer verseNumber;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;


}