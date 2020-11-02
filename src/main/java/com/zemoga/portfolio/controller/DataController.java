package com.zemoga.portfolio.controller;

import com.zemoga.portfolio.model.User;
import com.zemoga.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class DataController {

    public static final int SIZE_DESCRIPTION = 160;
    public static final int BEGIN_INDEX = 0;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getid/{id}")
    public User getById(@PathVariable long id){

        return userRepository.findById(id).get();
    }

    @RequestMapping("/getuser/{user}")
    public List<User> getByUser(@PathVariable String user){

        return userRepository.findBytwitterUserName(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable long id){
        user.setIdPortfolio(id);
        user.setDescription((user.getDescription().length() > SIZE_DESCRIPTION) ?
                user.getDescription().substring(BEGIN_INDEX,SIZE_DESCRIPTION) : user.getDescription());
        userRepository.save(user);
        return userRepository.save(user);
    }
}
