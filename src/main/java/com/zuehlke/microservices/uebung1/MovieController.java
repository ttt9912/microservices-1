package com.zuehlke.microservices.uebung1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1")
@RestController
public class MovieController {

    private final MovieServiceAdapter movieServiceAdapter;
    private final RatingAdapter ratingAdapter;

    public MovieController(MovieServiceAdapter movieServiceAdapter, RatingAdapter ratingAdapter) {
        this.movieServiceAdapter = movieServiceAdapter;
        this.ratingAdapter = ratingAdapter;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieServiceAdapter.getAll();
    }

    @GetMapping("/movies/{id}")
    public MovieDetail getMovieDetails(@PathVariable("id") long id) {

        Optional<MovieDetail> movieDetail = movieServiceAdapter.getMovieById(id);
        List<Rating> ratings = ratingAdapter.getRatingsById(id);

        return movieDetail.map(m -> m.setRatings(ratings)).orElseThrow(RuntimeException::new);
    }


}
