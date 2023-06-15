package com.example.expensetracker.Controller;

import com.example.expensetracker.Entities.User;
import com.example.expensetracker.Repositories.UserRepos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserRepos userRepos;

    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping(value = "/login")
    public User getUserDataAfterLogin(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<User> userList = userRepos.findByEmail(securityContext.getAuthentication().getPrincipal().toString());
        userList.get(0).setPassword(null);
        return userList.get(0);
    }

    @PostMapping(value = "/register")
    public User registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepos.save(user);
        return user;
    }

}
