package com.shakalinux.app.Repository;

import com.shakalinux.app.model.Verse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVerse extends JpaRepository<Verse,Long> {
}
