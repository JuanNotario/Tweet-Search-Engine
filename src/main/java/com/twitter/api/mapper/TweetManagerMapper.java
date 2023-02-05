package com.twitter.api.mapper;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import com.twitter.api.service.model.request.SearchTweetRequest;
import com.twitter.api.service.model.response.SearchTweetRsp;
import org.mapstruct.Mapper;

@Mapper
public interface TweetManagerMapper {

    SearchTweetRequest toSearchTweetRequest(SearchTweetIDTO searchTweetIDTO);

    SearchTweetODTO toSearchTweetODTO(SearchTweetRsp searchTweetRsp);
}
