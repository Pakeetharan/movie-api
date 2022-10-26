/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.controller;

import com.epic.movieapp.bean.MovieBean;
import com.epic.movieapp.bean.ResponseBean;
import com.epic.movieapp.service.MovieService;
import com.epic.movieapp.util.varlist.MessageVarList;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseBean getAllMovies() {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResponse(MessageVarList.RSP_SUCCESS);
        responseBean.setContent(movieService.getAllMovie());
        return responseBean;
    }

    @GetMapping(value = "/{id}")
    public ResponseBean getMovie(@PathVariable String id) {
        ResponseBean responseBean = new ResponseBean();
        if (movieService.movieExistByImdb(id)) {
            responseBean.setResponse(MessageVarList.RSP_SUCCESS);
            responseBean.setContent(movieService.getMovieByImdb(id));
        } else {
            responseBean.setResponse(MessageVarList.RSP_NO_DATA_FOUND);
        }
        return responseBean;
    }

    @PostMapping("/add")
    public ResponseBean addMovie(@Valid @RequestBody MovieBean bean) {
        movieService.createMovie(bean);
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResponse(MessageVarList.RSP_SUCCESS);
        return responseBean;
    }

    @PutMapping("/update")
    public ResponseBean updateMovie(@Valid @RequestBody MovieBean bean) {
        movieService.updateMovie(bean);
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResponse(MessageVarList.RSP_SUCCESS);
        return responseBean;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseBean deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResponse(MessageVarList.RSP_SUCCESS);
        return responseBean;
    }
}
