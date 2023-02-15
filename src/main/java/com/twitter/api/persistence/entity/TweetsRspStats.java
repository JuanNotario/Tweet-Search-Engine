package com.twitter.api.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(value = "tweetsRsp")
@AllArgsConstructor
@NoArgsConstructor
public class TweetsRspStats {
    @Id
    private String id;
    private String user;
    private List<TweetsInfoStats> editHistoryTweetIds;
}
