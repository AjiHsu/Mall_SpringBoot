package com.ajihsu.springbootmall.service.Impl;

import com.ajihsu.springbootmall.dao.UserDao;
import com.ajihsu.springbootmall.dto.UserRegisterRequest;
import com.ajihsu.springbootmall.model.User;
import com.ajihsu.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
