package com.twitter.api.controller.rdto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorRSRDTO {

    @ApiModelProperty(value = "code", name = "code", dataType = "String")
    private String code;

    @JsonProperty(value = "message_error")
    @ApiModelProperty(value = "message_error", name = "messageError", dataType = "List<String>")
    private List<String> messageError;
}
