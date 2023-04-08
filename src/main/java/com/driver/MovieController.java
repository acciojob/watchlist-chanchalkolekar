package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    // private static final int ResponseEntity = 0;
    @Autowired
    MovieService movieservice;

    @PostMapping("/add-movies")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieservice.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieservice.addDirector(director);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("m") String name,
            @RequestParam("d") String director) {
        movieservice.addMovieDirectorPair(name, director);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie) {
        return new ResponseEntity<Movie>(movieservice.getMovieByName(movie), HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String director) {
        return new ResponseEntity<Director>(movieservice.getDirectorByName(director), HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorname) {
        return new ResponseEntity<List<String>>(movieservice.getMoviesByDirectorName(directorname), HttpStatus.CREATED);
    }

    @GetMapping("get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        return new ResponseEntity<>(movieservice.findAllMovies(), HttpStatus.CREATED);
    }

    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String directorname) {
        movieservice.deleteDirectorByName(directorname);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        movieservice.deleteAllDirectors();
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

}
