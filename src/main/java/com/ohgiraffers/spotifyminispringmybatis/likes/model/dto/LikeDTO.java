package com.ohgiraffers.spotifyminispringmybatis.likes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikeDTO {

    private int likeId;

    private int userId;

    private int musicId;

    private String musicTitle;

    private String artist;

}
