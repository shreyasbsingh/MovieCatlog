package com.movieCatalog.moviecatalogservice.models;

import java.util.List;

public class userRating {
    private List<Rating> userRating;

    public userRating() {
    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
