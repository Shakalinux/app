package com.shakalinux.app.Repository;

import com.shakalinux.app.model.Profile;
import com.shakalinux.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProfile extends JpaRepository<Profile, Long> {
    Profile findByUser(User user);
}
