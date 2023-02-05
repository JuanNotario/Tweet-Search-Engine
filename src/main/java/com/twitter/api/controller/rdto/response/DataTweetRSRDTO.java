package com.twitter.api.controller.rdto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DataTweetRSRDTO {

    @JsonProperty(value = "edit_history_tweet_ids")
    @ApiModelProperty(value = "edit_history_tweet_ids", name = "editHistoryTweetIds", dataType = "List<String>")
    private List<String> editHistoryTweetIds;

    @ApiModelProperty(value = "id", name = "id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "text", name = "text", dataType = "String")
    private String text;
}
