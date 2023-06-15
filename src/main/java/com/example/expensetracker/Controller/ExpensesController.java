package com.example.expensetracker.Controller;

import com.example.expensetracker.Entities.Expense;
import com.example.expensetracker.Repositories.ExpenseRepo;
import com.example.expensetracker.Repositories.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class ExpensesController {

    @Autowired
    UserRepos userRepos;

    @Autowired
    ExpenseRepo expenseRepo;

    @PostMapping("/add")
    public Expense addNew(@RequestBody Expense transaction){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        transaction.setUser(userRepos.findByEmail(authentication.getPrincipal().toString()).get(0));
        expenseRepo.save(transaction);
        return transaction;
    }

    @GetMapping("/getExpenses")
    public List<Expense> getExpeses(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return expenseRepo.findByUserEmail(authentication.getPrincipal().toString());
    }
}
