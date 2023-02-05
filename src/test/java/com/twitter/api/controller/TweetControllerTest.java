package com.twitter.api.controller;

import com.twitter.api.controller.rdto.request.SearchTweetRQRDTO;
import com.twitter.api.controller.rdto.response.SearchTweetRSRDTO;
import com.twitter.api.controller.transformer.TweetControllerTransformer;
import com.twitter.api.manager.TweetManager;
import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class TweetControllerTest {

    @InjectMocks
    private TweetController tweetController;

    @Mock
    private TweetManager tweetManager;

    @Mock
    private TweetControllerTransformer tweetControllerTransformer;

    @Test
    void shouldSuccessSearchTweet() {
        when(tweetControllerTransformer.toSearchTweetIDTO(any())).thenReturn(new SearchTweetIDTO());
        when(tweetManager.searchTweet(any())).thenReturn(new SearchTweetODTO());
        when(tweetControllerTransformer.toSearchTweetRSRDTO(any())).thenReturn(new SearchTweetRSRDTO());

        val searchTweetRSRDTOResponseEntity = tweetController.searchTweet(new SearchTweetRQRDTO());

        assertEquals(OK, searchTweetRSRDTOResponseEntity.getStatusCode());
    }

}