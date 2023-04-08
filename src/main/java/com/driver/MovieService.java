package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movierepo;

    public void addMovie(Movie movie) {
        movierepo.addMovie(movie);
    }

    public void addDirector(Director director) {
        movierepo.addDirector(director);
    }

    public void addMovieDirectorPair(String name, String director) {
        movierepo.addMovieDirectorPair(name, director);
    }

    public Movie getMovieByName(String movie) {
        return movierepo.getMovieByName(movie);
    }

    public Director getDirectorByName(String director) {
        return movierepo.getDirectorByName(director);
    }

    public List<String> getMoviesByDirectorName(String directorname) {
        return movierepo.getMoviesByDirectorName(directorname);
    }

    public void deleteDirectorByName(String directorname) {
        movierepo.deleteDirectorByName(directorname);
    }

    public void deleteAllDirectors() {
        movierepo.deleteAllDirectors();
    }

    public List<String> findAllMovies() {
        return movierepo.findAllMovies();
    }
}
