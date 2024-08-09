package com.example.user_api.resources.impl;

import com.example.user_api.domain.User;
import com.example.user_api.resources.UserResource;
import com.example.user_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResourceImpl implements UserResource {

    private final UserService userService;

    @Override
    public ResponseEntity<User> findById(Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok(list);
    }
}
