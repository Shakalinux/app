package com.shakalinux.app.service;

import com.shakalinux.app.Repository.RepositoryUser;
import com.shakalinux.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private RepositoryUser repositoryUser;

    public User saveUser(User user) {
        return repositoryUser.save(user);
    }

    public User findUserById(Long id) {
        return repositoryUser.findById(id).orElse(null);
    }

    public User findUserByEmail(String email) {
        return repositoryUser.findByEmail(email);
    }



}