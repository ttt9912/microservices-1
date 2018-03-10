package com.zuehlke.microservices.uebung1;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface RatingApiClient {

    @RequestLine("GET /api/v1/ratings/{id}")
    List<RatingServiceResponse> getRatingById(@Param("id") long id);

}
