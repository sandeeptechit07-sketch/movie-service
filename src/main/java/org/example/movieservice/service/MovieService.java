package org.example.movieservice.service;

import org.example.movieservice.exception.MovieNotFoundException;
import org.example.movieservice.model.Movie;
import org.example.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found" + id));
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(String id, Movie movie) {

        Movie existingMovie = getMovieById(id);

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setDurationMinutes(movie.getDurationMinutes());
        existingMovie.setCertificate(movie.getCertificate());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}