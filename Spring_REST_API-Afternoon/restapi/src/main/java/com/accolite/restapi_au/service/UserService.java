package com.accolite.restapi_au.service;

import com.accolite.restapi_au.entity.User;

public interface UserService {
    public User addUser(User user);

    public User getUserById(Integer id);

    public  User getUserByEmail(String email);

    public User updateUser(User user);

    public String deleteUser(Integer id);
}
