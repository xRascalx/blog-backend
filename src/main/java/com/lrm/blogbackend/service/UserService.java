package com.lrm.blogbackend.service;

import com.lrm.blogbackend.entity.User;

public interface UserService {

    User checkUser(String username, String password);
}
