package com.twitter.api.persistence.dao;

import com.twitter.api.persistence.entity.TweetsRspStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TweetsRspStatsDao  extends MongoRepository<TweetsRspStats, String> {
}
