package com.example.demo.dao;

import com.example.demo.core.User;

import java.util.Collection;

public interface UserDao {
    User getOne(long id);
    Collection<User> getAll();
    void addUser(User user);
}
