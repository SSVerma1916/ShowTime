package com.ssverma.showtime.api;

import com.ssverma.showtime.BuildConfig;
import com.ssverma.showtime.model.MovieResponse;
import com.ssverma.showtime.model.ReviewsResponse;
import com.ssverma.showtime.model.VideosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbService {
    @GET("movie/popular?api_key=" + BuildConfig.TmdbApiKey)
    Call<MovieResponse> getPopularMovies(@Query("page") int pageNumber);

    @GET("movie/top_rated?api_key=" + BuildConfig.TmdbApiKey)
    Call<MovieResponse> getTopRatedMovies(@Query("page") int pageNumber);

    @GET("movie/{filter}?api_key=" + BuildConfig.TmdbApiKey)
    Call<MovieResponse> getMovies(@Path("filter") String filter, @Query("page") int pageNumber);

    @GET("movie/{movie_id}/videos?api_key=" + BuildConfig.TmdbApiKey)
    Call<VideosResponse> getVideos(@Path("movie_id") int movieId);

    @GET("movie/{movie_id}/reviews?api_key=" + BuildConfig.TmdbApiKey)
    Call<ReviewsResponse> getReviews(@Path("movie_id") int movieId, @Query("page") int pageNumber);
}
