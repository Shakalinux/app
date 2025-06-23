package com.shakalinux.app.Repository;

import com.shakalinux.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User,Long> {
    User findByEmail(String email);

}
