package com.ms.user.service.impl;

import com.ms.user.model.UserEntity;
import com.ms.user.pojo.UserPojo;
import com.ms.user.repositories.UserRepository;
import com.ms.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserEntity save(UserPojo user) {
        var userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity = userRepository.save(userEntity);
        return userEntity;
    }
}
