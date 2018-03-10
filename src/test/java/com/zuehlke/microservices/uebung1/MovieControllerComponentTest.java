package com.zuehlke.microservices.uebung1;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerComponentTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void getMovies() throws Exception {
        when()
                .get("api/v1/movies")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(1))
                .body("id", contains(1, 2, 3));
    }

    @Test
    public void getMovieById() throws Exception {

        when()
                .get("movies/1")
                .then()
                .statusCode(200)
                .body("movie.id", equalTo(1));
    }

}
