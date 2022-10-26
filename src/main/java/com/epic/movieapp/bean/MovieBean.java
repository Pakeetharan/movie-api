/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieBean {
    @NotNull
    private String imdb;

    @NotNull
    private String title;
    private String description;
    private BigDecimal rating;
    private String category;
    private Short year;
    private String imageUrl;

}
