package com.movies.service;

import com.movies.dto.ActorDTO;
import com.movies.dto.FilmDTO;
import com.movies.entity.Actor;
import com.movies.entity.Film;
import com.movies.entity.FilmActor;
import com.movies.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements IFilmService{

    @Autowired
    FilmRepository filmRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public Collection<Film> findAll() {

        Collection<Film> actors = new ArrayList<>();
        this.filmRepository
                .findAll()
                .forEach((film)->actors.add(film));
        return actors;
    }

    public Film getByID(Long id){
        return this.filmRepository.getByID(id);
    }

    @Override
    public Film mapToFilm(FilmDTO filmDTO) {

        Film film = this.mapper.map(filmDTO, Film.class);
        Collection<FilmActor> filmActors = new ArrayList<>();

        filmDTO.getActorDTOS()
                .stream()
                .forEach(actorDTO -> {
                    Actor actor = mapToActor(actorDTO);
                    FilmActor filmActor = new FilmActor(film, actor);
                    filmActors.add(filmActor);
                });
        film.setFilmActors(filmActors);
        return film;
    }

    public Actor mapToActor(ActorDTO actorDTO){
        return this.mapper.map(actorDTO, Actor.class);
    }

    @Override
    public Film saveNewFilm(Film film) {
        return this.filmRepository.save(film);
    }
}
