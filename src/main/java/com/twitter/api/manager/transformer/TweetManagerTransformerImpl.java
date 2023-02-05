package com.twitter.api.manager.transformer;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import com.twitter.api.mapper.TweetManagerMapper;
import com.twitter.api.service.model.request.SearchTweetRequest;
import com.twitter.api.service.model.response.SearchTweetRsp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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

}
