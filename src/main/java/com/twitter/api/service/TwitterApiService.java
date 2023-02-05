package com.twitter.api.service;

import com.twitter.api.service.model.request.SearchTweetRequest;
import com.twitter.api.service.model.response.SearchTweetRsp;

public interface TwitterApiService {
    SearchTweetRsp apiTwitterCall(SearchTweetRequest searchTweetRequest);
}
