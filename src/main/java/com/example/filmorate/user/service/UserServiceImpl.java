package com.example.filmorate.user.service;

import com.example.filmorate.user.dto.UserDto;
import com.example.filmorate.user.mapper.UserMapper;
import com.example.filmorate.user.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserStorage userStorage;

    @Autowired
    public UserServiceImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return UserMapper.userToDto(userStorage.addUser(UserMapper.dtoToUser(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return UserMapper.userToDto(userStorage.updateUser(UserMapper.dtoToUser(userDto)));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserMapper.listUserToDto(userStorage.getAllUsers());
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserMapper.userToDto(userStorage.getUserById(id));
    }
}
