package org.cobra.controller;

import org.cobra.entity.User;
import org.cobra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/say")
    public String say() {
        return userService.saySomething(applicationName);
    }

    @RequestMapping("/list")
    public String listUsers() {
        List<User> users = userService.findAll();
        return users.toString();
    }

    @RequestMapping("/delete/{id}")
    public String delUser(@PathVariable int id) {
        userService.deleteById(id);
        return "delete user successfully";
    }

}
