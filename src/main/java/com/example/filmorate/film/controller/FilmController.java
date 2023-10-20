package com.example.filmorate.film.controller;

import com.example.filmorate.film.dto.FilmDto;
import com.example.filmorate.film.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping()
    public FilmDto addFilm(@RequestBody FilmDto filmDto) {
        log.info("Получен POST запрос на добавление фильма с АйДи" + filmDto.getId());
        return filmService.addFilm(filmDto);
    }

    @PutMapping()
    public FilmDto updateFilm(@RequestBody FilmDto filmDto) {
        log.info("Получен PUT запрос на обновление фильма с АйДи " + filmDto.getId());
        return filmService.updateFilm(filmDto);
    }

    @GetMapping()
    public List<FilmDto> getAllFilms() {
        log.info("Получен GET запрос на получение списка всех фильмов");
        return filmService.getAllFilms();
    }

    @GetMapping("/getFilmById/{id}")
    public FilmDto getFilmById(@PathVariable("id") Long id) {
        log.info("Получен GET запрос на получение фильма по АйДи " + id);
        return filmService.getFilmById(id);
    }
}
