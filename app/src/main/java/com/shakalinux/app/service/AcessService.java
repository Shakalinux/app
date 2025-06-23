package com.shakalinux.app.service;

import com.shakalinux.app.Repository.RepositoryAcess;
import com.shakalinux.app.model.Acess;
import com.shakalinux.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessService {
    @Autowired
    private RepositoryAcess repositoryAcess;

    public List<Acess> acessesUsers(User user){
        return repositoryAcess.findByUser(user);
    }


}
