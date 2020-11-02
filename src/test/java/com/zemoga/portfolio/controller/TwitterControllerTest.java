package com.zemoga.portfolio.controller;

import com.google.gson.Gson;
import com.zemoga.portfolio.model.TwitterModel;
import com.zemoga.portfolio.services.TwitterService;
import com.zemoga.portfolio.services.interfaces.ITwitterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TwitterControllerTest {

    @InjectMocks
    private TwitterController TwitterController;

    @Mock
    private ITwitterService twitterService;

    private Gson gson = new Gson();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenGetByUserThenReturnTwitterList() {

        TwitterModel twitt = new TwitterModel("twitterUser","message");
        List<TwitterModel> twittsExpected = new ArrayList<>();
        twittsExpected.add(twitt);
        when(twitterService.getTwitterInfo("twitterUser")).thenReturn(twittsExpected);
        assertEquals(gson.toJson(twittsExpected),gson.toJson(TwitterController.getByUser("twitterUser")));
    }


}
