package com.twitter.api.controller.transformer;

import com.twitter.api.controller.rdto.request.SearchTweetRQRDTO;
import com.twitter.api.controller.rdto.response.SearchTweetRSRDTO;
import com.twitter.api.controller.transformer.mapper.TweetControllerMapper;
import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TweetControllerTransformerImpl implements TweetControllerTransformer {

    private final TweetControllerMapper tweetControllerMapper;

    @Override
    public SearchTweetIDTO toSearchTweetIDTO(SearchTweetRQRDTO searchTweetRQRDTO) {
        return tweetControllerMapper.toSearchTweetIDTO(searchTweetRQRDTO);
    }

    @Override
    public SearchTweetRSRDTO toSearchTweetRSRDTO(SearchTweetODTO searchTweetODTO) {
        return tweetControllerMapper.toSearchTweetRSRDTO(searchTweetODTO);
    }
}
