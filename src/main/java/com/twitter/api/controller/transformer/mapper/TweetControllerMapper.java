package com.twitter.api.controller.transformer.mapper;

import com.twitter.api.controller.rdto.request.SearchTweetRQRDTO;
import com.twitter.api.controller.rdto.response.SearchTweetRSRDTO;
import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import org.mapstruct.Mapper;

@Mapper
public interface TweetControllerMapper {

    SearchTweetIDTO toSearchTweetIDTO(SearchTweetRQRDTO searchTweetRQRDTO);

    SearchTweetRSRDTO toSearchTweetRSRDTO(SearchTweetODTO searchTweetODTO);
}
