package com.ohgiraffers.spotifyminispringmybatis.common;

import lombok.*;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int status;

    private String message;

}
