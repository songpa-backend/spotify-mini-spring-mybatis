package com.ohgiraffers.spotifyminispringmybatis.comment.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {

    private int comment_id;
    private String content;
    private int userId;
    private int musicId;


}
