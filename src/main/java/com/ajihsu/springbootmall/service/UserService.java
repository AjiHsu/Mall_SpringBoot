package com.ajihsu.springbootmall.service;

import com.ajihsu.springbootmall.dto.UserRegisterRequest;
import com.ajihsu.springbootmall.model.User;

public interface UserService {
    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
}
