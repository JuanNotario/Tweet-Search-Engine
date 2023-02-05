package com.twitter.api.manager.model.odto;

import lombok.Data;
import java.util.List;

@Data
public class SearchTweetODTO {
    private List<DataTweetODTO> data;
}
