package com.zemoga.portfolio.model;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class TwitterModelTest {

    @Test
    public void whenCreateModelThenGetAttributes() {

        TwitterModel twitterModel = new TwitterModel("user", "text");
        assertAll(
                () -> Assertions.assertEquals("user",twitterModel.getUser()),
                () -> Assertions.assertEquals("text",twitterModel.getText())
        );
    }
}
