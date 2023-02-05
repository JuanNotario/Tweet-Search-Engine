package com.twitter.api.manager;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import org.springframework.web.client.RestClientException;

public interface TweetManager {

    SearchTweetODTO searchTweet(SearchTweetIDTO searchTweetIDTO) throws RestClientException;
}
