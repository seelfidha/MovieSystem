package com.movies.service;

import com.movies.dto.FilmDTO;
import com.movies.entity.Film;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface IFilmService {

    Collection<Film> findAll();

    Film getByID(Long id);

    Film mapToFilm(FilmDTO filmDTO);

    Film saveNewFilm(Film film);
}
