package com.movies.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movies.entity.Actor;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Collection;

@Data
public class ActorDTO {

    private Long id;

    private String name;

    private String familyName;

    @JsonBackReference
    private Collection<FilmDTO>filmDTOS;

    public static ActorDTO mapToActorDTO(Actor actor){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(actor, ActorDTO.class);
    }
}
