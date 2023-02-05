package com.twitter.api.manager.transformer;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import com.twitter.api.service.model.request.SearchTweetRequest;
import com.twitter.api.service.model.response.SearchTweetRsp;

public interface TweetManagerTransformer {

    SearchTweetRequest toSearchTweetRequest(SearchTweetIDTO searchTweetIDTO);

    SearchTweetODTO toSearchTweetODTO(SearchTweetRsp searchTweetRsp);
}
