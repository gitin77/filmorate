package com.example.filmorate.util;

import com.example.filmorate.exception.ValidateException;
import com.example.filmorate.film.model.Film;
import com.example.filmorate.user.model.User;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class Validator {

    public void validateFilm(Film film) {
        if (film.getName().isEmpty()) {
            throw new ValidateException("введено пустое имя");
        } else if (film.getDescription().length() > 200) {
            throw new ValidateException("описание превышает допустимую длину");
        } else if (film.getReleaseDate().isBefore(LocalDate.of(1895, 12, 28))) {
            throw new ValidateException("введена недопустимая дата");
        } else if (film.getDuration() <= 0) {
            throw new ValidateException("введена недопустимая продолжительность");
        }
    }

    public void validateUser(User user) {
        if (user.getEmail().isEmpty() || !user.getEmail().contains("@")) {
            throw new ValidateException("введена некорректная электронная почта");
        } else if (user.getLogin().isBlank()) {
            throw new ValidateException("введен пустой логин или содержит пробелы");
        } else if (user.getBirthday().isAfter(LocalDate.now())) {
            throw new ValidateException("неверная дата рождения");
        } else if (user.getName() == null || user.getName().isEmpty()) {
            user.setName(user.getLogin());
        }
    }
}
