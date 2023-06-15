package com.example.expensetracker.Repositories;

import com.example.expensetracker.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepos extends CrudRepository<User, Integer> {
    List<User> findByEmail(String email);
}
