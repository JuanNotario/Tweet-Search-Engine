package com.twitter.api.service;

import com.twitter.api.service.model.request.SearchTweetRequest;
import com.twitter.api.service.model.response.SearchTweetRsp;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class TwitterApiServiceImplTest {

    @InjectMocks
    private TwitterApiServiceImpl twitterApiService;

    @Mock
    private RestTemplate restTemplate;

    private SearchTweetRequest searchTweetRequest;

    @BeforeEach
    void setUp() {
        setField(twitterApiService, "twitterUrl", "https://api.twitter.com/2/tweets");
        searchTweetRequest = buildSearchTweetRequest();
    }

    @Test
    void shouldSuccessApiTwitterCall() {
        when(restTemplate.exchange(anyString(), any(), any(), eq(SearchTweetRsp.class)))
                .thenReturn(ok(new SearchTweetRsp()));

        twitterApiService.apiTwitterCall(searchTweetRequest);

        verify(restTemplate).exchange(anyString(), any(), any(), eq(SearchTweetRsp.class));
    }

    @Test
    void shouldErrorApiTwitterCall() {
        when(restTemplate.exchange(anyString(), any(), any(), eq(SearchTweetRsp.class)))
                .thenThrow(new RestClientException("Api Twitter call error"));

        assertThrows(RestClientException.class, () -> twitterApiService.apiTwitterCall(searchTweetRequest));
    }

    private SearchTweetRequest buildSearchTweetRequest() {
        return SearchTweetRequest.builder()
                .token("token")
                .userName("user_name")
                .build();
    }

}