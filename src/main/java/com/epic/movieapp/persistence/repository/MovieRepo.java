/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.persistence.repository;

import com.epic.movieapp.bean.MovieBean;
import com.epic.movieapp.persistence.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, String> {
    boolean existsByImdb(String id);

    @Query("select new com.epic.movieapp.bean.MovieBean(e.imdb, e.title, e.description, e.rating, e.category, e.year, e.imageUrl) from MovieEntity e")
    Optional<List<MovieBean>> getAllMovie();

    @Query("select new com.epic.movieapp.bean.MovieBean(e.imdb, e.title, e.description, e.rating, e.category, e.year, e.imageUrl) from MovieEntity e where e.imdb=:imdb")
    Optional<MovieBean> findMovieById(String imdb);

    void deleteByImdb(String id);

    MovieEntity findByImdb(String id);
}
