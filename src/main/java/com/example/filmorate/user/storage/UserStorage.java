package com.example.filmorate.user.storage;

import com.example.filmorate.user.model.User;

import java.util.List;

public interface UserStorage {
    User addUser(User user);

    User updateUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);
}
