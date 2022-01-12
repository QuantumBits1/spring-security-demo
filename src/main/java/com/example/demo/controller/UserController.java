package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.core.User;
import com.example.demo.UserProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
@Slf4j
@Validated
public class UserController {
/*
    @Value("${greeting}")
    private String message;
*/
    @Inject
    private UserService userService;
    @Inject
    private UserProperties userProperties;

    public UserController() {

    }

    @GetMapping
    public Collection<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.get(id);
    }

    @GetMapping(path="/single", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getSingleUser(@RequestParam("id") Optional<Long> optional) {
        return ResponseEntity.ok(userService.get(optional.orElse(1L)));
    }

    @GetMapping(path="/msg")
    public String getMessage(@RequestHeader("user-agent") String userAgent) {
        return userProperties.getGreeting() + " using " + userAgent;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.add(user);
        if(user.getId() > 0) {
            URI uri = URI.create("/demo/api/v1/user/" + user.getId());
            return ResponseEntity.accepted().location(uri).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
