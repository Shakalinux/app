package com.shakalinux.app.Repository;

import com.shakalinux.app.model.Acess;
import com.shakalinux.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RepositoryAcess extends JpaRepository<Acess, String> {
    List<Acess> findByUserAndDataAcessoBetween(User user, LocalDate startDate, LocalDate endDate);
    List<Acess> findByUser(User user);
}
