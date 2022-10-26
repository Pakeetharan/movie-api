/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.service;

import com.epic.movieapp.bean.MovieBean;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Optional<List<MovieBean>> getAllMovie();

    Optional<MovieBean> getMovieByImdb(String imdb);

    boolean movieExistByImdb(String imdb);

    void createMovie(MovieBean bean);

    void updateMovie(MovieBean bean);

    void deleteMovie(String imdb);
}
