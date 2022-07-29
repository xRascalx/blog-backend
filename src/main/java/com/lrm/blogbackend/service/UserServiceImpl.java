package com.lrm.blogbackend.service;

import com.lrm.blogbackend.Repository.UserRepository;
import com.lrm.blogbackend.entity.User;
import com.lrm.blogbackend.util.MD5Utils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User checkUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
    }
}
