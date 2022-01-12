package com.example.demo.dao;

import com.example.demo.core.College;
import com.example.demo.core.User;

import javax.inject.Named;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Named
public class UserDaoImpl implements UserDao {
    private Map<Long, User> users;
    private NavigableMap<Long, College> colleges;

    {
        users = new HashMap<>();
        users.put(1L, new User(1L, "Abu", "991230115432", LocalDate.of(2000, Month.DECEMBER, 30), 30));
        users.put(2L, new User(2L, "Ali", "991229115432", LocalDate.of(2000, Month.DECEMBER, 30), 29));
        users.put(3L, new User(3L, "Ahmad", "991229115432", LocalDate.of(2000, Month.DECEMBER, 30), 29));
        users.put(4L, new User(4L, "Akmal", "991229115432", LocalDate.of(2000, Month.DECEMBER, 30), 29));
        users.put(5L, new User(5L, "Afiq", "991229115432", LocalDate.of(2000, Month.DECEMBER, 30), 29));

        colleges = new TreeMap<>();
        colleges.put(2L, new College("Multimedia University", "Street 1", "City 1", "State 1"));
        colleges.put(2L, new College("Universiti Teknologi Petronas", "Street 2", "City 2", "State 2"));
        colleges.put(3L, new College("Asia Pacific University", "Street 3", "City 3", "State 3"));
        colleges.put(4L, new College("Monash University", "Street 4", "City 4", "State 4"));
        colleges.put(5L, new College("Taylor College", "Street 5", "City 5", "State 5"));
    }

    @Override
    public User getOne(long id) {
        return users.get(id);
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public void addUser(User user) {
        long id = users.keySet().stream().count();
        id++;
        user.setId(id);
        users.put(id, user);
    }
}
