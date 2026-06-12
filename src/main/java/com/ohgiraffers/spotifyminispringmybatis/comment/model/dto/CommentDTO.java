package com.ohgiraffers.spotifyminispringmybatis.comment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {

    //@JsonProperty("comment_id")
    private Integer commentId;
    private String content;
    private int userId;
    private int musicId;

    public int getId() {
        return this.commentId;
    }

}
