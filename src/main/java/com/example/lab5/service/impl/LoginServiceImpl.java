package com.example.lab5.service.impl;

import com.example.lab5.repo.LoginRepo;
import com.example.lab5.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private final LoginRepo loginRepo;

    public LoginServiceImpl() {
        this.loginRepo = new LoginRepo();
    }

    @Override
    public boolean isExistAccount(String username, String password) {
        return loginRepo.isExistAccount(username, password);
    }
}
