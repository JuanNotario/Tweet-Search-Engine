package com.twitter.api.manager.model.odto;

import lombok.Data;

import java.util.List;

@Data
public class DataTweetODTO {
    private List<String> editHistoryTweetIds;
    private String id;
    private String text;
}
