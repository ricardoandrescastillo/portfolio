package com.zemoga.portfolio.services;

import com.zemoga.portfolio.model.TwitterModel;
import com.zemoga.portfolio.services.interfaces.ITwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterService implements ITwitterService {

    public static final String API_KEY = "KRy7l0v8wex3w8Sy5zThai3Ea";
    public static final String SECRET_KEY = "X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu";
    public static final String TOKEN = "1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja";
    public static final String SECRET_TOKEN = "tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj";
    public static final int MAX_SIZE = 5;

    Logger logger = LoggerFactory.getLogger(TwitterService.class);

    @Override
    public List<TwitterModel> getTwitterInfo (String user) {

        List<TwitterModel> twittersModel = new ArrayList<>();
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(API_KEY, SECRET_KEY);
        twitter.setOAuthAccessToken(new AccessToken(TOKEN, SECRET_TOKEN));

        try {
            List<Status> statuses;
            statuses = twitter.getUserTimeline(user);
            statuses.stream().limit(MAX_SIZE).collect(Collectors.toList()).forEach(status -> {
                TwitterModel twitterModel = new TwitterModel(status.getUser().getScreenName(), status.getText());
                twittersModel.add(twitterModel);
            });
        } catch (TwitterException e) {
            logger.error("Failed to get Twitter {}", e.getErrorMessage());
        }
        
        return  twittersModel;
    }
}
