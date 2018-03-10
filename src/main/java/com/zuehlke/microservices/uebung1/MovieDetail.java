package com.zuehlke.microservices.uebung1;

import java.util.List;

public class MovieDetail {

    private Movie movie;
    private String plot;
    private int year;
    private String genre;
    private List<Rating> ratings;

    public MovieDetail(Movie movie, String plot, int year, String genre, List<Rating> ratings) {
        this.movie = movie;
        this.plot = plot;
        this.year = year;
        this.genre = genre;
        this.ratings = ratings;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public MovieDetail setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }
}

class Rating{
    private String source;
    private String value;

    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (source != null ? !source.equals(rating.source) : rating.source != null) return false;
        return value != null ? value.equals(rating.value) : rating.value == null;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
