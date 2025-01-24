package com.green.greengram.feed.like;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.greengram.common.model.ResultResponse;
import com.green.greengram.feed.like.model.FeedLikeReq;
import lombok.RequiredArgsConstructor;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor
public class FeedLikeTestCommon {
    final ObjectMapper objectMapper;

    MultiValueMap<String, String> getParameter(long feedId) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>(1);
        queryParams.add("feedId", String.valueOf(feedId));
        return queryParams;
    }

    FeedLikeReq getGivenParam(long feedId) {
        FeedLikeReq givenParam = new FeedLikeReq();
        givenParam.setFeedId(feedId);
        return givenParam;
    }

    String getExpectedResJson(int result) throws Exception {
        ResultResponse expectedRes = ResultResponse.<Integer>builder()
                .resultMessage(result == 0 ? "좋아요 취소" : "좋아요 등록")
                .resultData(result)
                .build();
        return objectMapper.writeValueAsString(expectedRes);
    }
}
