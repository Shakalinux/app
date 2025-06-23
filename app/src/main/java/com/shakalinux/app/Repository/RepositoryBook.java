package com.shakalinux.app.Repository;

import com.shakalinux.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBook extends JpaRepository<Book,Long> {
}
