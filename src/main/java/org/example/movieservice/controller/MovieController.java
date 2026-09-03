package org.example.movieservice.controller;

import org.example.movieservice.model.Movie;
import org.example.movieservice.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(
            @PathVariable String id,
            @RequestBody Movie movie) {

        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable String id) {

        movieService.deleteMovie(id);

        return "Movie deleted successfully";
    }
}