package com.twitter.api.controller.rdto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class SearchTweetRSRDTO {

    @ApiModelProperty(value = "data", name = "data", dataType = "List<DataTweetRSRDTO>")
    private List<DataTweetRSRDTO> data;
}
