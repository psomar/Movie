package com.somar.moview;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=" + BuildConfig.API_KEY + "&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie?token=" + BuildConfig.API_KEY + "&field=id")
    Single<TrailerResponse> loadTrailers(@Query("search") int id);

    @GET("review?token=" + BuildConfig.API_KEY + "&field=movieId")
    Single<ReviewResponse> loadReviews(@Query("search") int id);

    @GET("movie?token=" + BuildConfig.API_KEY + "&field=id")
    Single<ActorResponse> loadActors(@Query("search") int id);


}
