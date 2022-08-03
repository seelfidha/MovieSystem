package com.movies;

import com.movies.repository.ActorRepository;
import com.movies.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MoviesApplication{

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private FilmRepository filmRepository;

	public static void main(String[] args) {
		System.out.println("hello world");
		SpringApplication.run(MoviesApplication.class, args);
	}

	@PostConstruct
	private void postInit(){
		System.out.println("All saved actors are :"+ actorRepository.findAll());
		System.out.println("All saved movies are :"+ filmRepository.findAll());
	}


}
