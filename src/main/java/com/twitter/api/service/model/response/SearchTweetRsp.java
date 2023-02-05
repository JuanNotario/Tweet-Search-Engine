package com.twitter.api.service.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchTweetRsp implements Serializable {
    private List<DataTweetRsp> data;

}
