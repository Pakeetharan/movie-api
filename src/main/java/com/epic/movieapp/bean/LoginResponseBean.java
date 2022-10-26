/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseBean {
    private String token;
    private String expireIn = "1440 Mins";
}
