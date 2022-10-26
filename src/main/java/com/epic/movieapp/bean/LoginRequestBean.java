/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.bean;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequestBean {

    @NotNull(message = "Email cannot be empty")
    @Email(message = "Enter a valid Email")
    private String email;

    @NotNull(message = "Password cannot be empty")
    private String password;
}
