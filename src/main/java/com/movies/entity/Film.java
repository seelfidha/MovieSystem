package com.movies.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.movies.dto.FilmDTO;
import lombok.Data;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(name = "film")
@Data
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Film {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "film", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<FilmActor> filmActors;

    public Collection<Actor>getActors(){
        return this.filmActors
                .stream()
                .map(fa-> fa.getActor()).collect(Collectors.toList());
    }

    public static Film mapToFilm(FilmDTO filmDTO){

        ModelMapper mapper = new ModelMapper();
        Film film = mapper.map(filmDTO, Film.class);
        return film;
    }
}
