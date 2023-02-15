package com.twitter.api.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TweetsInfoStats {
    private List<String> editHistoryTweetIds;
    private String id;
    private String text;
}
