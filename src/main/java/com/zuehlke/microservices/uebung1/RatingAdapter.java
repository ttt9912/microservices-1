package com.zuehlke.microservices.uebung1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatingAdapter {

    private RatingApiClient ratingApiClient;

    public RatingAdapter(String url) {
        ratingApiClient = RestClientFactory.createClientWithFallback(url, RatingApiClient.class, (id) -> Collections.emptyList());
    }

    public List<Rating> getRatingsById(long id) {
        List<RatingServiceResponse> response = ratingApiClient.getRatingById(id);
        List<Rating> ratings = new ArrayList<>();
        response.stream().forEach(r -> ratings.add(new Rating(r.getSource(), r.getValue())));
        return ratings;
    }
}
