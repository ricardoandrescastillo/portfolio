package com.zemoga.portfolio.controller;

import com.zemoga.portfolio.model.TwitterModel;
import com.zemoga.portfolio.services.interfaces.ITwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/twitter")
public class TwitterController {


    @Autowired
    private ITwitterService twitterService;

    @RequestMapping("/getwitter/{user}")
    public List<TwitterModel> getByUser(@PathVariable String user) {

        return twitterService.getTwitterInfo(user);
    }


}
