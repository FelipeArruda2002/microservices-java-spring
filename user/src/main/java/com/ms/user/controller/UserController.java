package com.ms.user.controller;

import com.ms.user.model.UserEntity;
import com.ms.user.pojo.UserPojo;
import com.ms.user.producer.UserProducer;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    final UserService userService;
    final UserProducer userProducer;

    public UserController(UserService userService, UserProducer userProducer) {
        this.userService = userService;
        this.userProducer = userProducer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity save(@RequestBody @Valid UserPojo userPojo) {
        UserEntity user = userService.save(userPojo);
        userProducer.publishMessage(user);
        return user;
    }
}
