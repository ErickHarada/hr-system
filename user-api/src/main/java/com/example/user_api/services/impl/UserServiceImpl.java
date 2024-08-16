package com.example.user_api.services.impl;

import com.example.user_api.domain.User;
import com.example.user_api.exceptions.ObjectNotFoundException;
import com.example.user_api.repositories.UserRepository;
import com.example.user_api.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final Environment env;
    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on {} port", env.getProperty("local.server.port"));
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
