package com.movies.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "actor")
@Data
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actor {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String familyName;

    @OneToMany(mappedBy = "actor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<FilmActor> filmActors;

}
