package com.example.expensetracker.Repositories;

import com.example.expensetracker.Entities.Expense;
import com.example.expensetracker.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Integer> {
    List<Expense> findByUserEmail(String email);
}
