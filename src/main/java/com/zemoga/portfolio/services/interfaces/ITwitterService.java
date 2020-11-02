package com.zemoga.portfolio.services.interfaces;

import com.zemoga.portfolio.model.TwitterModel;

import java.util.List;

public interface ITwitterService {

    List<TwitterModel> getTwitterInfo (String user);
}
