package com.zemoga.portfolio.services;

import com.zemoga.portfolio.model.TwitterModel;
import com.zemoga.portfolio.services.interfaces.ITwitterService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class TwitterServiceTest {

    @InjectMocks
    ITwitterService twitterService = new TwitterService();

    @Test
    public void test() throws Exception {
       List<TwitterModel> list =  twitterService.getTwitterInfo("@falcao");
       assertTrue("size is 5",list.size()==5);
    }
}
