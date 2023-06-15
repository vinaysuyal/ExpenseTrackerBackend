package com.example.expensetracker.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User  {
    @jakarta.persistence.Id
    private int Id;
    @NotNull
    private String name;
    @Email
    @NotNull
    private String email;
    private String password;

}
