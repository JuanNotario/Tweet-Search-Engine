package com.twitter.api.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "search_tweets_stats")
public class SearchTweetStats implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "search_id", columnDefinition = "serial")
    @GeneratedValue(strategy = IDENTITY)
    private Long searchId;

    @Column(name = "twitter_user")
    private String twitterUser;

    @Column(name = "request_date")
    private String requestDate;

    @Column(name = "response_date")
    private String responseDate;
}
