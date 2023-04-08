package com.driver;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> db;
    private HashMap<String, Director> db2;
    private HashMap<String, List<String>> db3;

    public MovieRepository() {
        this.db = new HashMap<String, Movie>();

        this.db2 = new HashMap<String, Director>();
        this.db3 = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie) {
        db.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        db2.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String name, String director) {
        if (db.containsKey(name) && db2.containsKey(director)) {
            List<String> temp = new ArrayList<>();
            if (db3.containsKey(director)) {
                temp = db3.get(director);
            }
            temp.add(name);
            db3.put(director, temp);

        }
    }

    public Movie getMovieByName(String movie) {
        return db.get(movie);
    }

    public Director getDirectorByName(String director) {
        return db2.get(director);
    }

    public List<String> getMoviesByDirectorName(String directorname) {
        List<String> list = new ArrayList<>();
        if (db3.containsKey(directorname)) {
            list = (db3.get(directorname));
        }
        return list;
    }

    public void deleteDirectorByName(String directorname) {
        List<String> list = new ArrayList<>();
        if (db3.containsKey(directorname)) {
            list = db3.get(directorname);
            for (String name : list) {
                if (db.containsKey(name))
                    db.remove(name);
            }
            db3.remove(directorname);
        }
        if (db2.containsKey(directorname)) {
            db2.remove(directorname);
        }
    }

    public void deleteAllDirectors() {
        HashSet<String> hash = new HashSet<>();

        for (String director : db3.keySet()) {
            for (String movie : db3.get(director)) {
                hash.add(movie);
            }
            db3.remove(director);
        }

        for (String name : hash) {
            if (db.containsKey(name)) {
                db.remove(name);
            }
        }
    }

    public List<String> findAllMovies() {
        List<String> list = new ArrayList<>();
        for (String name : db.keySet()) {
            list.add(name);
        }
        return list;
    }
}
