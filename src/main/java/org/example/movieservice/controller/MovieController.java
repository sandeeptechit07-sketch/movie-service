package org.example.movieservice.controller;

import org.apache.coyote.Request;
import org.example.movieservice.model.Movie;
import org.example.movieservice.response.ResponseStatus;
import org.example.movieservice.service.MovieService;
import org.example.movieservice.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseStatus<List<Movie>>> getAllMovies() {
        List <Movie> Movies=movieService.getAllMovies();

        return ResponseEntity.ok(
                new ResponseStatus<>(true, "Movies fetched successfully", Movies)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStatus<Movie>> getMovieById(@PathVariable String id) {

        Movie movie = movieService.getMovieById(id);

        return ResponseEntity.ok(
                new ResponseStatus<>(true, "Movie fetched successfully", movie)
        );
    }

    @PostMapping
    public ResponseEntity<ResponseStatus<Movie>> createMovie(@RequestBody Movie movie) {
        Movie createMovie=movieService.createMovie(movie);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseStatus<>(true, "Movie created successfully", createMovie)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseStatus<Movie>> updateMovie(
            @PathVariable String id,
            @RequestBody Movie movie) {

        Movie updatedMovie = movieService.updateMovie(id, movie);

        return ResponseEntity.ok(
                new ResponseStatus<>(true, "Movie updated successfully", updatedMovie)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStatus<Void>> deleteMovie(@PathVariable String id) {

        movieService.deleteMovie(id);

        return ResponseEntity.ok(
                new ResponseStatus<>(true, "Movie deleted successfully", null)
        );
    }
}