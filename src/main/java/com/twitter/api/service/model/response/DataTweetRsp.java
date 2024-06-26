package com.twitter.api.service.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTweetRsp implements Serializable {
    @JsonProperty("edit_history_tweet_ids")
    private List<String> editHistoryTweetIds;
    private String id;
    private String text;
}
