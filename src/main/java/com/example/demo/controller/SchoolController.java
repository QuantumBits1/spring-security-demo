package com.example.demo.controller;

import com.example.demo.core.College;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/school")
public class SchoolController {
    @Inject
    UserService userService;

    @GetMapping
    public ModelAndView getAllSchools() {
        Collection<College> colleges = userService.getUsers()
                .stream()
                .map(p -> p.getCollege()).distinct().collect(Collectors.toList());

        return new ModelAndView("home", "colleges", colleges);
    }
}
