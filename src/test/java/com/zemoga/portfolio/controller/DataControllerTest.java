package com.zemoga.portfolio.controller;

import com.google.gson.Gson;
import com.zemoga.portfolio.model.User;
import com.zemoga.portfolio.repository.UserRepository;
import com.zemoga.portfolio.services.interfaces.ITwitterService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class DataControllerTest {

    @InjectMocks
    private DataController dataController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ITwitterService twitterService;

    private Gson gson = new Gson();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void whenGetByIdThenReturnUser() {
        User userExpected = doUser();
        Optional<User> optionalUser = Optional.of(userExpected);
        when(userRepository.findById(1l)).thenReturn(optionalUser);
        User user = dataController.getById(1L);
        assertEquals(gson.toJson(userExpected), gson.toJson(user));
    }

    @Test
    void whengetByUserThenReturnUser() {
        User userExpected = doUser();
        List<User> usersExpected = new ArrayList<>();
        usersExpected.add(userExpected);
        when(userRepository.findBytwitterUserName("twitterUserName")).thenReturn(usersExpected);
        List<User> users = dataController.getByUser("twitterUserName");
        assertEquals(gson.toJson(usersExpected), gson.toJson(users));
    }

    @Test
    void whenUpdateUserThenReturnUserUpdated() {
        User userExpected = doUser();
        when(userRepository.save(userExpected)).thenReturn(userExpected);
        User user = dataController.updateUser(userExpected,1L);
        assertEquals(gson.toJson(userExpected), gson.toJson(user));
    }

   private User doUser() {
       String userJson = "{\n" +
               "    \"idPortfolio\": 1,\n" +
               "    \"description\": \"description\",\n" +
               "    \"imageUrl\": \"imageUrl\",\n" +
               "    \"twitterUserName\": \"twitterUserName\",\n" +
               "    \"title\": \"title\"\n" +
               "}";
       User user = gson.fromJson(userJson,User.class);
       return user;
   }


}
