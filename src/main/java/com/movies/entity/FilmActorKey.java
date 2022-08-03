package com.movies.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class FilmActorKey implements Serializable {

    private static final long serialVersionUID = -477535510907726394L;

    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "film_id")
    private Long filmId;

    public FilmActorKey(Long actorId, Long filmId){
        this.actorId = actorId;
        this.filmId = filmId;
    }
}
