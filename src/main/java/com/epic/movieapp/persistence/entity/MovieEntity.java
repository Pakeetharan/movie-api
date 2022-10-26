package com.epic.movieapp.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class MovieEntity {
    @Id
    @Column(name = "imdb", nullable = false)
    private String imdb;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "description", length = 64)
    private String description;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    @Column(name = "category")
    private String category;

    @Column(name = "year")
    private Short year;

    @Column(name = "image_url", length = 2083)
    private String imageUrl;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "updated_time")
    private Instant updatedTime;

}