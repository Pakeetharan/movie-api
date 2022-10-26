/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.service.impl;

import com.epic.movieapp.bean.MovieBean;
import com.epic.movieapp.exception.AlreadyExistsException;
import com.epic.movieapp.persistence.entity.MovieEntity;
import com.epic.movieapp.persistence.repository.MovieRepo;
import com.epic.movieapp.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;

    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public Optional<List<MovieBean>> getAllMovie() {
        return movieRepo.getAllMovie();
    }

    @Override
    public Optional<MovieBean> getMovieByImdb(String imdb) {
        // if(!movieExistByImdb(imdb)) throw new NoDataFoundException("No Movie found for id "+ imdb);
        return movieRepo.findMovieById(imdb);
    }

    @Override
    public boolean movieExistByImdb(String imdb) {
        return movieRepo.existsByImdb(imdb);
    }

    @Override
    public void createMovie(MovieBean bean) {
        if(movieExistByImdb(bean.getImdb())) throw new AlreadyExistsException("Movie exists with id "+ bean.getImdb());

        MovieEntity entity = new MovieEntity();
        entity.setImdb(bean.getImdb());
        entity.setTitle(bean.getTitle());
        entity.setDescription(bean.getDescription());
        entity.setCategory(bean.getCategory());
        entity.setRating(bean.getRating());
        entity.setYear(bean.getYear());
        entity.setImageUrl(bean.getImageUrl());

        movieRepo.save(entity);
    }

    @Override
    public void updateMovie(MovieBean bean) {
        if(movieExistByImdb(bean.getImdb())) throw new AlreadyExistsException("Movie exists with id "+ bean.getImdb());

        MovieEntity entity = movieRepo.findByImdb(bean.getImdb());
        entity.setTitle(bean.getTitle());
        entity.setDescription(bean.getDescription());
        entity.setCategory(bean.getCategory());
        entity.setRating(bean.getRating());
        entity.setYear(bean.getYear());
        entity.setImageUrl(bean.getImageUrl());

        movieRepo.save(entity);
    }

    @Override
    public void deleteMovie(String imdb) {
        movieRepo.deleteById(imdb);
    }
}
