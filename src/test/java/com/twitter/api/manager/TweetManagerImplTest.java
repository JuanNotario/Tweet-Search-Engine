package com.twitter.api.manager;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import com.twitter.api.manager.transformer.TweetManagerTransformer;
import com.twitter.api.persistence.dao.SearchTweetStatsDao;
import com.twitter.api.service.TwitterApiService;
import com.twitter.api.service.model.request.SearchTweetRequest;
import com.twitter.api.service.model.response.SearchTweetRsp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TweetManagerImplTest {

    @InjectMocks
    private TweetManagerImpl tweetManager;

    @Mock
    private TweetManagerTransformer tweetManagerTransformer;

    @Mock
    private TwitterApiService twitterApiService;

    @Mock
    private SearchTweetStatsDao searchTweetStatsDao;

    @Test
    public void searchTweetTest() {
        when(tweetManagerTransformer.toSearchTweetRequest(any())).thenReturn(new SearchTweetRequest());
        when(twitterApiService.apiTwitterCall(any())).thenReturn(new SearchTweetRsp());
        when(tweetManagerTransformer.toSearchTweetODTO(any())).thenReturn(new SearchTweetODTO());

        tweetManager.searchTweet(new SearchTweetIDTO());

        verify(twitterApiService).apiTwitterCall(any());
        verify(searchTweetStatsDao).save(any());
    }

}