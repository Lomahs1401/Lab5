package com.example.lab5.service.impl;

import com.example.lab5.repo.RegisterRepo;
import com.example.lab5.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepo registerRepo;

    public RegisterServiceImpl() {
        this.registerRepo = new RegisterRepo();
    }

    @Override
    public boolean createNewAccount(String username, String password) {
        return registerRepo.createNewAccount(username, password);
    }
}
