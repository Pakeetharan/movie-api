/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.controller;

import com.epic.movieapp.bean.LoginRequestBean;
import com.epic.movieapp.bean.LoginResponseBean;
import com.epic.movieapp.bean.ResponseBean;
import com.epic.movieapp.bean.SignupRequestBean;
import com.epic.movieapp.service.JwtUtil;
import com.epic.movieapp.service.UserService;
import com.epic.movieapp.util.varlist.MessageVarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseBean login(@Valid @RequestBody LoginRequestBean bean) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(bean.getEmail(), bean.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            try {
                UserDetails userDetails = userService.loadUserByUsername(bean.getEmail());
                final String jwt = jwtUtil.generateToken(userDetails);
                LoginResponseBean loginResponseBean = new LoginResponseBean();
                loginResponseBean.setToken(jwt);
                responseBean.setResponse(MessageVarList.RSP_SUCCESS);
                responseBean.setContent(loginResponseBean);
                return responseBean;
            } catch (UsernameNotFoundException e) {
                responseBean.setResponse(MessageVarList.RSP_NO_DATA_FOUND);
                return responseBean;
            }
        } catch (AuthenticationException e) {
            responseBean.setResponse(MessageVarList.RSP_NOT_AUTHORISED);
            return responseBean;
        }
    }

    @PostMapping("/signup")
    public ResponseBean signUp(@Valid @RequestBody SignupRequestBean bean) {
        ResponseBean responseBean = new ResponseBean();
        if(userService.userExistsByEmail(bean.getEmail())){
            responseBean.setResponse(MessageVarList.RSP_FAIL);
            return responseBean;
        } else {
            userService.signUp(bean);
            responseBean.setResponse(MessageVarList.RSP_SUCCESS);
            return responseBean;
        }

    }
}
