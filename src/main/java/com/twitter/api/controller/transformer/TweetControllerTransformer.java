package com.twitter.api.controller.transformer;

import com.twitter.api.controller.rdto.request.SearchTweetRQRDTO;
import com.twitter.api.controller.rdto.response.SearchTweetRSRDTO;
import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;

public interface TweetControllerTransformer {
    SearchTweetIDTO toSearchTweetIDTO(SearchTweetRQRDTO searchTweetRQRDTO);

    SearchTweetRSRDTO toSearchTweetRSRDTO(SearchTweetODTO searchTweetODTO);
}
