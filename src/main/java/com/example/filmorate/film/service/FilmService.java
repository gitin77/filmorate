package com.example.filmorate.film.service;

import com.example.filmorate.film.dto.FilmDto;

import java.util.List;

public interface FilmService {
    FilmDto addFilm(FilmDto filmDto);

    FilmDto updateFilm(FilmDto filmDto);

    List<FilmDto> getAllFilms();

    FilmDto getFilmById(Long id);
}
