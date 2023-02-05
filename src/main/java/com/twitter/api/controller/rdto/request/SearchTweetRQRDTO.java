package com.twitter.api.controller.rdto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchTweetRQRDTO {

    @NotBlank(message = "Parameter token is mandatory")
    @ApiModelProperty(value = "token", name = "token", dataType = "String", required = true)
    private String token;

    @JsonProperty(value = "user_name")
    @NotBlank(message = "Parameter user_name is mandatory")
    @ApiModelProperty(value = "user_name", name = "userName", dataType = "String", required = true)
    private String userName;
}
