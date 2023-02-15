package com.twitter.api.manager;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import com.twitter.api.manager.transformer.TweetManagerTransformer;
import com.twitter.api.persistence.dao.SearchTweetStatsDao;
import com.twitter.api.persistence.dao.TweetsRspStatsDao;
import com.twitter.api.persistence.entity.SearchTweetStats;
import com.twitter.api.persistence.entity.TweetsInfoStats;
import com.twitter.api.persistence.entity.TweetsRspStats;
import com.twitter.api.service.TwitterApiService;
import com.twitter.api.service.model.response.SearchTweetRsp;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static java.util.Calendar.getInstance;

@Component
@AllArgsConstructor
public class TweetManagerImpl implements TweetManager {
    private final TwitterApiService twitterApiService;
    private final TweetManagerTransformer tweetManagerTransformer;
    private final SearchTweetStatsDao searchTweetStatsDao;
    private final TweetsRspStatsDao tweetsRspStatsDao;

    @Override
    public SearchTweetODTO searchTweet(SearchTweetIDTO searchTweetIDTO) throws RestClientException {
        val searchTweetRequest = tweetManagerTransformer.toSearchTweetRequest(searchTweetIDTO);

        val requestDate = getInstance().getTime();
        val searchTweetResponse = twitterApiService.apiTwitterCall(searchTweetRequest);
        val responseDate = getInstance().getTime();

        val userName = searchTweetIDTO.getUserName();
        saveRequestStats(userName, requestDate.toString(), responseDate.toString());
        saveRspStats(searchTweetResponse, userName);

        return tweetManagerTransformer.toSearchTweetODTO(searchTweetResponse);
    }

    private void saveRequestStats(String twitterUser, String requestDate, String responseDate) {
        val searchTweetStats = tweetManagerTransformer.toSearchTweetStats(twitterUser, requestDate, responseDate);
        searchTweetStatsDao.save(searchTweetStats);
    }

    private void saveRspStats(SearchTweetRsp searchTweetRsp, String user) {
        val tweetsRspStats = tweetManagerTransformer.toTweetsRspStats(searchTweetRsp, user);
        tweetsRspStatsDao.insert(tweetsRspStats);
    }
}