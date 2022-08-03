package com.movies.controller;

import com.movies.dto.FilmDTO;
import com.movies.entity.Film;
import com.movies.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/film")
public class FilmRestController {

    @Autowired
    IFilmService filmService;

    @GetMapping(value = "/all")
    @ResponseBody
    public Collection<FilmDTO> getAll(){
        Collection<Film> films = this.filmService.findAll();
        return films
                .stream()
                .map(film -> FilmDTO.mapToFilmDTO(film))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public FilmDTO getActorByID(@PathVariable("id") Long id){

        Film film = this.filmService.getByID(id);
        if (Objects.nonNull(film)) {
            return FilmDTO.mapToFilmDTO(film);
        }
        return null;
    }

    @PostMapping
    @ResponseBody
    public FilmDTO saveFilm(@RequestBody FilmDTO filmDTO){

        Film request = this.filmService.mapToFilm(filmDTO);
        Film response = this.filmService.saveNewFilm(request);
        return FilmDTO.mapToFilmDTO(response);
    }
}
