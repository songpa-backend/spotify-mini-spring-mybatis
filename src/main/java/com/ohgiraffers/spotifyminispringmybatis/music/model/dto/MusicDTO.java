package com.ohgiraffers.spotifyminispringmybatis.music.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MusicDTO {

    @JsonProperty("music_id")
    private int musicId;
    private String title;
    private String artist;
    private String genre;
    private int duration;


}
