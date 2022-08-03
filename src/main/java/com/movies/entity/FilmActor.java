package com.movies.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "film_actor")
@Getter
@Setter
@NoArgsConstructor
public class FilmActor {

    @EmbeddedId
    private FilmActorKey filmActorId;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private Actor actor;

    public FilmActor(Film film, Actor actor){
        this.filmActorId = new FilmActorKey(actor.getId(), film.getId());
        this.film = film;
        this.actor = actor;
    }
}
