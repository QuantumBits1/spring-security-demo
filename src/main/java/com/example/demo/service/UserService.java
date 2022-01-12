package com.example.demo.service;

import com.example.demo.core.User;
import org.springframework.stereotype.Service;
import java.util.Collection;

public interface UserService {

    /*public List<User> getUsers() {
        return List.of(
                new User(1L, "Abu", "991230115432", LocalDate.of(2000, Month.DECEMBER, 30), 30),
                new User(2L, "Ali", "991229115432", LocalDate.of(2000, Month.DECEMBER, 30), 29)
        );
    }

    public User get() {
        return new User(2L, "Ali", "991229115432", LocalDate.of(2000, Month.DECEMBER, 30), 29);
    }*/

    User get(long id);
    Collection<User> getUsers();
    Collection<User> getAllUsersInDepartment(String department, String lastNameLike);
    void add(User user);
}
