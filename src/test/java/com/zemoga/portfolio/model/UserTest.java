package com.zemoga.portfolio.model;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class UserTest {

    private Gson gson = new Gson();

    @Test
    public void whenCreateUserThenGetAttributes(){

        User user = new User();
        user.setIdPortfolio(1L);
        user.setDescription("description");
        user.setImageUrl("imageUrl");
        user.setTitle("title");
        user.setTwitterUserName("twitterUserName");

        assertAll(
                () -> Assertions.assertEquals(1, user.getIdPortfolio()),
                () -> Assertions.assertEquals("description", user.getDescription()),
                () -> Assertions.assertEquals("imageUrl", user.getImageUrl()),
                () -> Assertions.assertEquals("twitterUserName", user.getTwitterUserName()),
                () -> Assertions.assertEquals("title", user.getTitle())
        );
    }
}
