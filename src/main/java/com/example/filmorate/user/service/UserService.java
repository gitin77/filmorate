package com.example.filmorate.user.service;


import com.example.filmorate.user.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);
}
