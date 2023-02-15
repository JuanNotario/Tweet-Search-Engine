package com.twitter.api.manager.transformer;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import com.twitter.api.persistence.entity.SearchTweetStats;
import com.twitter.api.persistence.entity.TweetsRspStats;
import com.twitter.api.service.model.request.SearchTweetRequest;
import com.twitter.api.service.model.response.SearchTweetRsp;
import com.twitter.api.manager.transformer.mapper.TweetManagerMapper;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

import static java.lang.String.valueOf;
import static java.util.concurrent.ThreadLocalRandom.current;

@Component
@AllArgsConstructor
public class TweetManagerTransformerImpl implements TweetManagerTransformer {

    private final TweetManagerMapper tweetManagerMapper;

    @Override
    public SearchTweetRequest toSearchTweetRequest(SearchTweetIDTO searchTweetIDTO) {
        return tweetManagerMapper.toSearchTweetRequest(searchTweetIDTO);
    }

    @Override
    public SearchTweetODTO toSearchTweetODTO(SearchTweetRsp searchTweetRsp) {
        return tweetManagerMapper.toSearchTweetODTO(searchTweetRsp);
    }

    @Override
    public SearchTweetStats toSearchTweetStats(String twitterUser, String requestDate, String responseDate) {
        return tweetManagerMapper.toSearchTweetStats(twitterUser, requestDate, responseDate);
    }

    @Override
    public TweetsRspStats toTweetsRspStats(SearchTweetRsp searchTweetRsp, String user) {
        val randomID = getRandomID();
        return tweetManagerMapper.toTweetsRspStats(searchTweetRsp, randomID, user);
    }

    private String getRandomID() {
        val randomID = current().nextInt(1, 999 + 1);

        return valueOf(randomID);
    }
}
