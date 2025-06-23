package com.shakalinux.app.service;

import com.shakalinux.app.Repository.RepositoryProfile;
import com.shakalinux.app.model.Profile;
import com.shakalinux.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private RepositoryProfile repositoryProfile;

    public Profile saveProfile(Profile profile) {
        return repositoryProfile.save(profile);
    }


    public Profile findByUser(User user) {
        return repositoryProfile.findByUser(user);
    }

}
