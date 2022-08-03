package com.movies.dto;

import com.movies.entity.Film;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
public class FilmDTO {

    private Long id;

    private String name;

    private String description;

    private Collection<ActorDTO>actorDTOS;

    public static FilmDTO mapToFilmDTO(Film film){
        ModelMapper mapper = new ModelMapper();
        //map actors to dto
        Collection<ActorDTO> actorDTOS =
                film.getFilmActors()
                .stream()
                .map(fa->mapper.map(fa.getActor(), ActorDTO.class))
                        .collect(Collectors.toList());
        FilmDTO filmDTO = mapper.map(film, FilmDTO.class);
        filmDTO.setActorDTOS(actorDTOS);
        return filmDTO;
    }
}
