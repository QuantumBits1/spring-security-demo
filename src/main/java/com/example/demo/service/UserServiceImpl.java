package com.example.demo.service;

import com.example.demo.core.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.Collection;

@Named
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User get(long id) {
        return userDao.getOne(id);
    }

    @Override
    public Collection<User> getUsers() {
        return userDao.getAll();
    }

    @Override
    public Collection<User> getAllUsersInDepartment(String department, String lastNameLike) {
        return null;
    }

    @Override
    public void add(User user) {
        if(user != null)
            userDao.addUser(user);
    }
}
