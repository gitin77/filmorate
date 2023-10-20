package com.example.filmorate.user.mapper;

import com.example.filmorate.user.dto.UserDto;
import com.example.filmorate.user.model.User;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UserMapper {


    //метод принимает ДТО, возвращает обычную модель
    public User dtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .login(userDto.getLogin())
                .name(userDto.getName())
                .birthday(userDto.getBirthday())
                .build();
    }

    //метод принимает обычную модель, возвращает ДТО
    public UserDto userToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .login(user.getLogin())
                .name(user.getName())
                .birthday(user.getBirthday()).build();
    }

    //метод принимает лист ДТО, возвращает лист обычной модели
    public List<User> listDtoToUser(List<UserDto> listUserDto) {
        return listUserDto.stream().map(UserMapper::dtoToUser).collect(Collectors.toList());
    }

    //метод принимает лист обычной модели, возвращает лист ДТО
    public List<UserDto> listUserToDto(List<User> listUser) {
        return listUser.stream().map(UserMapper::userToDto).collect(Collectors.toList());
    }
}
