package com.movies.repository;

import com.movies.entity.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

    @Query(value =
            "SELECT f FROM Film f " +
                    "JOIN FilmActor FA on FA.film = f " +
                    "JOIN Actor a on a = FA.actor " +
                    "WHERE f.id =:filmID"
    )
    Film getByID(@Param("filmID")Long filmID);
}
