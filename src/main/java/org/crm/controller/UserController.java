package org.crm.controller;

import org.crm.model.User;
import org.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/public")
    public String pub(){
        return "public page";
    }

//    @PostMapping("/public/add")
//    public String addUser(@RequestBody User user){
//        return userService.addUser(user);
//    }
}
