package com.movieCatalog.moviecatalogservice.resources;

import com.movieCatalog.moviecatalogservice.models.CatalogItem;
import com.movieCatalog.moviecatalogservice.models.Movie;
import com.movieCatalog.moviecatalogservice.models.Rating;
import com.movieCatalog.moviecatalogservice.models.userRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;  //name doesnt matter the type matters and if multiple of same type is there then we need to tag it and also while autowireing it we specify which
    @Autowired                                    //one to use it could for different use cases.
    private DiscoveryClient discoveryClient;
    @Autowired
    private WebClient.Builder webClientBuilder;
    @RequestMapping("/{userId}")
   public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
       //get all rated movie Ids


       //communication happens through rest template what we get back is string so need objects to deal with it.
       //RestTemplate restTemplate=new RestTemplate(); //here everytime browser refreshes the template gets created evrytime so not good hence we need to use bean where one object
                                                        //gets cretaed once and is shared accross all the java class and use DI to use that bean anywhere in the application.implimented in line 22


        userRating ratings= restTemplate.getForObject("http://RATING-INFO-SERVICE/ratingdata/user/"+userId, userRating.class);
       //ww get the movie he has watched now we have the movies he has watched now we make the api call to get those details though api call using REST
       //Template
        return ratings.getUserRating().stream().map(rating -> {
                    //for each movie ID call movie info service and get data
                    Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);//makes a rest call to any url doesnt need to be a microservice and returns a string.so if we know the payload of that response is the call then we can create a                     // class for that exact same properties create the instance of that class populate those properties to it give a object.
                    //put them together
                    return new CatalogItem(movie.getName(),movie.getOverview(),rating.getRating());
        })
        .collect(Collectors.toList());//making that as a list and returning that.

    }
}

         /* Movie movie=webClientBuilder.build() //using builder pattern and giving a client
                  .get()//chaing mech to tell that use get method
                  .uri("http://localhost:8082/movies/" + rating.getMovieId())//where to make the request
                  .retrieve()//go fetch
                  .bodyToMono(Movie.class).block(); */    //whatever u get back convert it to movie class bodoytomono is a reactive way to it will give what u want in future.