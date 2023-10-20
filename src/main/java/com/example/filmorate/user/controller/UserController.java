package com.example.filmorate.user.controller;

import com.example.filmorate.user.dto.UserDto;
import com.example.filmorate.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserDto addUser(@RequestBody UserDto userDto) {
        log.info("Получен POST запрос на добавление нового пользователя с АйДи " + userDto.getId());
        return userService.addUser(userDto);
    }

    @PutMapping()
    public UserDto updateUser(@RequestBody UserDto userDto) {
        log.info("Получен PUT запрос на обновление существующего пользователя с АйДи " + userDto.getId());
        return userService.updateUser(userDto);
    }

    @GetMapping()
    public List<UserDto> getAllUsers() {
        log.info("Получен GET запрос на получение списка всех пользователей");
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        log.info("Получен GET запрос на получение пользователя по АйДи " + id);
        return userService.getUserById(id);
    }
}
