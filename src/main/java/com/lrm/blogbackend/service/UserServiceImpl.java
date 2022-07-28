package com.lrm.blogbackend.service;

import com.lrm.blogbackend.Repository.UserRepository;
import com.lrm.blogbackend.entity.User;
import com.lrm.blogbackend.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
