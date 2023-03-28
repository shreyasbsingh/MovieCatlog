package com.movieCatalog.ratinginfoservice.Resource;

import com.movieCatalog.ratinginfoservice.models.Rating;
import com.movieCatalog.ratinginfoservice.models.userRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingdata")

public class RatingResource {
    @RequestMapping("{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);

    }
    @RequestMapping("/user/{userId}")
    public userRating getUserRating(@PathVariable("userId") String userId){

        List<Rating> ratings= Arrays.asList(
                new Rating("100",4),
                new Rating("200",5)
        );
        userRating userRating = new userRating();
        userRating.setUserRating(ratings);
        return userRating;

    }
}
