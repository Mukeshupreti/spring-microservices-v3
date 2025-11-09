package com.example.utils;

class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void addUser(String name) {
        repo.save(name);
    }

    public boolean isValid(String name) {
        return name != null && !name.trim().isEmpty();
    }
}