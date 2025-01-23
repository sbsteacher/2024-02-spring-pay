package com.green.greengram.feed.comment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.greengram.common.MyFileUtils;
import com.green.greengram.common.model.ResultResponse;
import com.green.greengram.feed.comment.model.FeedCommentDto;
import com.green.greengram.feed.comment.model.FeedCommentGetReq;
import com.green.greengram.feed.comment.model.FeedCommentGetRes;
import com.green.greengram.feed.like.FeedLikeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
      controllers = FeedCommentController.class
    , excludeAutoConfiguration = SecurityAutoConfiguration.class
)
class FeedCommentControllerTest {
    @Autowired ObjectMapper objectMapper; //JSON사용
    @Autowired MockMvc mockMvc; //요청(보내고)-응답(받기) 처리
    @MockBean FeedCommentService feedCommentService;

    final long feedId_2 = 2L;
    final long feedCommentId_3 = 3L;
    final long writerUserId_4 = 4L;

    @Test
    void getFeedComment() throws Exception {
        final String URL = "/api/feed/comment";
        //?key1=value1&key2=value2&key3=value3
        //3개
        //feedId=2&startIdx=1&size=10
        //feedId=2&startIdx=1
        //feed_id=2&start_idx=1&size=20

        FeedCommentGetReq givenParam = new FeedCommentGetReq(feedId_2, 1, 20);

        FeedCommentDto feedCommentDto = new FeedCommentDto();
        feedCommentDto.setFeedId(feedId_2);
        feedCommentDto.setFeedCommentId(feedCommentId_3);
        feedCommentDto.setComment("코멘트");
        feedCommentDto.setWriterUserId(writerUserId_4);
        feedCommentDto.setWriterNm("작성자");
        feedCommentDto.setWriterPic("profile.jpg");

        FeedCommentGetRes expectedResult = new FeedCommentGetRes();
        expectedResult.setMoreComment(false);
        expectedResult.setCommentList(List.of(feedCommentDto));

        //service.getFeedComment에 임무부여
        given(feedCommentService.getFeedComment(givenParam)).willReturn(expectedResult);


        ResultActions resultActions = mockMvc.perform(get(URL).queryParams(  getParameter(givenParam)  ));

        //String expectedResJson = getExpectedResJson( ?? );


    }
    private MultiValueMap<String, String> getParameter(FeedCommentGetReq givenParam) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("feed_id", String.valueOf(givenParam.getFeedId()));
        queryParams.add("start_idx", String.valueOf(givenParam.getStartIdx()));
        queryParams.add("size", String.valueOf(givenParam.getSize()));
        return queryParams;

        //?feedId=2&key=value&name=hong
    }

    private String getExpectedResJson() throws Exception {
       return null;
    }
}