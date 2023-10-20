package com.example.filmorate.film.mapper;

import com.example.filmorate.film.dto.FilmDto;
import com.example.filmorate.film.model.Film;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class FilmMapper {

    //метод принимает ДТО, возвращает обычную модель
    public Film dtoToFilm(FilmDto filmDto) {
        return Film.builder()
                .id(filmDto.getId())
                .name(filmDto.getName())
                .description(filmDto.getDescription())
                .releaseDate(filmDto.getReleaseDate())
                .duration(filmDto.getDuration())
                .build();
    }

    //метод принимает обычную модель, возвращает ДТО
    public FilmDto filmToDto(Film film) {
        return FilmDto.builder()
                .id(film.getId())
                .name(film.getName())
                .description(film.getDescription())
                .releaseDate(film.getReleaseDate())
                .duration(film.getDuration())
                .build();
    }

    //метод принимает лист ДТО, возвращает лист обычной модели
    public List<Film> listDtoToFilm(List<FilmDto> listFilmDto) {
        return listFilmDto.stream().map(FilmMapper::dtoToFilm).collect(Collectors.toList());
    }

    //метод принимает лист обычной модели, возвращает лист ДТО
    public List<FilmDto> listFilmToDto(List<Film> listFilm) {
        return listFilm.stream().map(FilmMapper::filmToDto).collect(Collectors.toList());
    }
}
