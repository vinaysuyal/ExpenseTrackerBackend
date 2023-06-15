package com.example.expensetracker.Controller;

import com.example.expensetracker.Entities.User;
import com.example.expensetracker.Repositories.UserRepos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserRepos userRepos;
    @PostMapping(value = "/login")
    public User getUserDataAfterLogin(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<User> userList = userRepos.findByEmail(securityContext.getAuthentication().getPrincipal().toString());
        return userList.get(0);
    }
}
