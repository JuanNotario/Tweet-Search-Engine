package com.twitter.api.controller;

import com.twitter.api.controller.rdto.request.SearchTweetRQRDTO;
import com.twitter.api.controller.rdto.response.ErrorRSRDTO;
import com.twitter.api.controller.rdto.response.SearchTweetRSRDTO;
import com.twitter.api.controller.transformer.TweetControllerTransformer;
import com.twitter.api.manager.TweetManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@Api(tags = "Tweet")
public class TweetController {
    private final TweetManager tweetManager;
    private final TweetControllerTransformer tweetControllerTransformer;

    @GetMapping(value = "/searchTweet", produces = "application/json")
    @ApiOperation(value = "Search all tweets from an account in the last 7 days")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Search Tweet success", response = SearchTweetRSRDTO.class), @ApiResponse(code = 500, message = "Internal Server Error",
            response = ErrorRSRDTO.class) })
    public ResponseEntity<SearchTweetRSRDTO> searchTweet(@Valid SearchTweetRQRDTO searchTweetRQRDTO) {
        val searchTweetIDTO = tweetControllerTransformer.toSearchTweetIDTO(searchTweetRQRDTO);
        val searchTweetODTO = tweetManager.searchTweet(searchTweetIDTO);
        val searchTweetRSRDTO = tweetControllerTransformer.toSearchTweetRSRDTO(searchTweetODTO);

        return ok(searchTweetRSRDTO);
    }
}
