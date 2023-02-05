package com.twitter.api.persistence.dao;

import com.twitter.api.persistence.entity.SearchTweetStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchTweetStatsDao extends JpaRepository<SearchTweetStats, Long> {

}
