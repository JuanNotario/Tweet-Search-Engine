package com.twitter.api.service;

import com.twitter.api.service.model.request.SearchTweetRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.twitter.api.service.model.response.SearchTweetRsp;
import lombok.val;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Slf4j
@Component
@RequiredArgsConstructor
public class TwitterApiServiceImpl implements TwitterApiService {
    private final RestTemplate restTemplate;

    @Value("${twitter.url}")
    private String twitterUrl;

    @Override
    public SearchTweetRsp apiTwitterCall(SearchTweetRequest searchTweetRequest) {
        val url = buildTwitterURL(searchTweetRequest.getUserName());

        val httpHeaders = getHttpHeaders(searchTweetRequest.getToken());
        val httpEntity = new HttpEntity(httpHeaders);

        try {
            val tweetResponseResponseEntity = restTemplate.exchange(url, GET, httpEntity, SearchTweetRsp.class);

            log.info("Api Twitter response: {}", tweetResponseResponseEntity.getBody());
            return tweetResponseResponseEntity.getBody();
        } catch (RestClientException e) {
            log.error("Api Twitter call error", e);
            throw new RestClientException("Api Twitter call error", e);
        }
    }

    private HttpHeaders getHttpHeaders(String token) {
        val httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        httpHeaders.setContentType(APPLICATION_JSON);

        return httpHeaders;
    }

    private String buildTwitterURL(String userName) {
        return fromHttpUrl(twitterUrl)
                .path("/search/recent")
                .queryParam("query", "from:" + userName)
                .build()
                .toUriString();
    }
}
