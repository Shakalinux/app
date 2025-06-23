package com.shakalinux.app.Repository;

import com.shakalinux.app.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryChapter extends JpaRepository<Chapter,Long> {
}
