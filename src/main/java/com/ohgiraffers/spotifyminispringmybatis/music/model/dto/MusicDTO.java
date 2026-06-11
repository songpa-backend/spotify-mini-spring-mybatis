package com.ohgiraffers.spotifyminispringmybatis.music.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MusicDTO {

    private int musicId;
    private String title;
    private String artist;
    private String genre;
    private int duration;

}
