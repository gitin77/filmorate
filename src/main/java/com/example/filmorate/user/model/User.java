package com.example.filmorate.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String email;
    private String login;
    private String name;
    private LocalDate birthday;
}
