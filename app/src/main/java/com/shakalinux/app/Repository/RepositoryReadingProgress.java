package com.shakalinux.app.Repository;

import com.shakalinux.app.model.ReadingProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryReadingProgress extends JpaRepository<ReadingProgress,Long> {
}
