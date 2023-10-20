package com.example.filmorate.film.storage;

import com.example.filmorate.exception.EntityNotFoundException;
import com.example.filmorate.film.model.Film;
import com.example.filmorate.util.Validator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
@Component
public class FilmStorageImpl implements FilmStorage {

    private Long idGen = 1L;
    private Map<Long, Film> filmMap = new HashMap<>();

    @Override
    public Film addFilm(Film film) {
        Validator.validateFilm(film);
        film.setId(idGen);
        filmMap.put(idGen, film);
        idGen++;
        log.info("добавлен новый фильм");
        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        Validator.validateFilm(film);
        if (filmMap.containsKey(film.getId())) {
            filmMap.put(film.getId(), film);
            log.info("фильм изменен");
            return film;
        } else {
            log.info("ошибка при изменении фильма");
            throw new EntityNotFoundException("не найдет данный фильм");
        }
    }

    @Override
    public List<Film> getAllFilms() {
        log.info("список всех фильмов");
        return new ArrayList<>(filmMap.values());
    }

    @Override
    public Film getFilmById(Long id) {
        log.info("получен фильм по АйДи" + id);
        return filmMap.get(id);
    }
}
