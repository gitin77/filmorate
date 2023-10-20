package com.example.filmorate.film.service;

import com.example.filmorate.film.dto.FilmDto;
import com.example.filmorate.film.mapper.FilmMapper;
import com.example.filmorate.film.storage.FilmStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmStorage filmStorage;

    @Autowired
    public FilmServiceImpl(FilmStorage filmStorage) {
        this.filmStorage = filmStorage;
    }

    @Override
    public FilmDto addFilm(FilmDto filmDto) {
        return FilmMapper.filmToDto(filmStorage.addFilm(FilmMapper.dtoToFilm(filmDto)));
    }

    @Override
    public FilmDto updateFilm(FilmDto filmDto) {
        return FilmMapper.filmToDto(filmStorage.updateFilm(FilmMapper.dtoToFilm(filmDto)));
    }

    @Override
    public List<FilmDto> getAllFilms() {
        return FilmMapper.listFilmToDto((filmStorage.getAllFilms()));
    }

    @Override
    public FilmDto getFilmById(Long id) {
        return FilmMapper.filmToDto(filmStorage.getFilmById(id));
    }
}
