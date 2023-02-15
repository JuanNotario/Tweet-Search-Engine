package com.twitter.api.manager.transformer.mapper;

import com.twitter.api.manager.model.idto.SearchTweetIDTO;
import com.twitter.api.manager.model.odto.SearchTweetODTO;
import com.twitter.api.persistence.entity.SearchTweetStats;
import com.twitter.api.persistence.entity.TweetsInfoStats;
import com.twitter.api.persistence.entity.TweetsRspStats;
import com.twitter.api.service.model.request.SearchTweetRequest;
import com.twitter.api.service.model.response.DataTweetRsp;
import com.twitter.api.service.model.response.SearchTweetRsp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TweetManagerMapper {

    SearchTweetRequest toSearchTweetRequest(SearchTweetIDTO searchTweetIDTO);

    SearchTweetODTO toSearchTweetODTO(SearchTweetRsp searchTweetRsp);

    SearchTweetStats toSearchTweetStats(String twitterUser, String requestDate, String responseDate);

    @Mapping(target = "editHistoryTweetIds", source = "searchTweetRsp.data")
    TweetsRspStats toTweetsRspStats(SearchTweetRsp searchTweetRsp, String id, String user);

    TweetsInfoStats toTweetsInfoStats(DataTweetRsp dataTweetRsp);
}
