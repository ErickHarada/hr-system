package com.example.user_api.services;

import com.example.user_api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();
}
