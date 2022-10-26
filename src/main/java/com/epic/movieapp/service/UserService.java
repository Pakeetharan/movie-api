/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.service;

import com.epic.movieapp.bean.SignupRequestBean;
import com.epic.movieapp.persistence.entity.UserEntity;
import com.epic.movieapp.persistence.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("No such user exists"));
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public boolean userExistsByEmail(String email) {
        return userRepo.existsByEmailIgnoreCase(email);
    }

    public void signUp(SignupRequestBean bean) {
        UserEntity entity = new UserEntity();

        entity.setEmail(bean.getEmail());
        entity.setFirstName(bean.getFirstName());
        entity.setLastName(bean.getLastName());
        entity.setPassword(new BCryptPasswordEncoder().encode(bean.getPassword()));

        userRepo.save(entity);
    }
}
