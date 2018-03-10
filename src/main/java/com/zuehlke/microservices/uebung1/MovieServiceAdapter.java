package com.zuehlke.microservices.uebung1;

import com.netflix.hystrix.exception.HystrixRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieServiceAdapter {

    private final MovieServiceApiClient moviesApiClient;

    public MovieServiceAdapter(String url) {
        moviesApiClient = RestClientFactory.createClient(url, MovieServiceApiClient.class);
    }

    public List<Movie> getAll() {
        List<MovieServiceResponse> response = moviesApiClient.getMovies();
        List<Movie> movies = new ArrayList<>();
        response.stream()
                .forEach(r -> movies.add(new Movie(
                        r.getId(),
                        r.getTitle(),
                        r.getPoster())));
        return movies;
    }

    public Optional<MovieDetail> getMovieById(long id) {
        try {
            MovieServiceResponse response = moviesApiClient.getMovieById(id);
            return Optional.of(new MovieDetail(
                    new Movie(
                            response.getId(),
                            response.getTitle(),
                            response.getPoster()),
                    response.getPlot(),
                    response.getYear(),
                    response.getGenre(),
                    null
            ));
        } catch (HystrixRuntimeException r) {
            System.out.println("Movie not found");
        }
        return Optional.empty();
    }
}
