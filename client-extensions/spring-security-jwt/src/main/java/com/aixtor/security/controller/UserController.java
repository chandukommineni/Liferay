package com.aixtor.security.controller;

import com.aixtor.security.jwt.JwtUtil;
import com.aixtor.security.model.User;
import com.aixtor.security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
   private UserService userService;


    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.login(user.getEmail(),user.getPassword());
    }

    @PostMapping("/register")
    public  User register(@RequestBody User user){
      return userService.register(user);
    }

    @GetMapping("/all-users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
