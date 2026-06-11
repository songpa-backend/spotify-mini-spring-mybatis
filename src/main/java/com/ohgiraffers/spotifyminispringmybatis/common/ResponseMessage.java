package com.ohgiraffers.spotifyminispringmybatis.common;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResponseMessage {

    private int status;

    private String message;

    private Map<String, Object> results;
}
