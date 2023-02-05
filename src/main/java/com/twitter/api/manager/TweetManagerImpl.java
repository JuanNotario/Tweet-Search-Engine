package com.twitter.api.manager;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import com.twitter.api.manager.transformer.TweetManagerTransformer;
import com.twitter.api.persistence.dao.SearchTweetStatsDao;
import com.twitter.api.persistence.entity.SearchTweetStats;
import com.twitter.api.service.TwitterApiService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.getInstance;

@Component
@AllArgsConstructor
public class TweetManagerImpl implements TweetManager {
    private final TwitterApiService twitterApiService;
    private final TweetManagerTransformer tweetManagerTransformer;
    private final SearchTweetStatsDao searchTweetStatsDao;

    @Override
    public SearchTweetODTO searchTweet(SearchTweetIDTO searchTweetIDTO) throws RestClientException {
        val searchTweetRequest = tweetManagerTransformer.toSearchTweetRequest(searchTweetIDTO);

        val requestDate = getInstance().getTime();
        val searchTweetResponse = twitterApiService.apiTwitterCall(searchTweetRequest);
        val responseDate = getInstance().getTime();

        saveStats(searchTweetIDTO.getUserName(), requestDate.toString(), responseDate.toString());

        return tweetManagerTransformer.toSearchTweetODTO(searchTweetResponse);
    }

    private void saveStats(String twitterUser, String requestDate, String responseDate) {
        val searchTweetStats = SearchTweetStats.builder()
                .twitterUser(twitterUser)
                .requestDate(requestDate)
                .responseDate(responseDate)
                .build();

        searchTweetStatsDao.save(searchTweetStats);
    }
}
