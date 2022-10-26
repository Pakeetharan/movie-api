/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class SignupRequestBean {

    @NotNull(message = "Email cannot be empty")
    @Email
    private String email;

    @NotNull(message = "First Name cannot be empty")
    private String firstName;

    @NotNull(message = "Last Name cannot be empty")
    private String lastName;

    @NotNull(message = "Password cannot be empty")
    private String password;
}
