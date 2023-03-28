package com.movieCatalog.movieinfoservice.models;

public class Movie {
    private String movieId;
    private String name;
    private String Overview;

    public Movie(String movieId, String name, String overview) {
        this.movieId = movieId;
        this.name = name;
        Overview=overview;

    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }
}
