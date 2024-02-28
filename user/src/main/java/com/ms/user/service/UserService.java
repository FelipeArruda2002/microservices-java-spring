package com.ms.user.service;

import com.ms.user.model.UserEntity;
import com.ms.user.pojo.UserPojo;

public interface UserService {

    UserEntity save(UserPojo user);
}
