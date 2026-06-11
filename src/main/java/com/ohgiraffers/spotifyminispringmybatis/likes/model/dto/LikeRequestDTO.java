package com.ohgiraffers.spotifyminispringmybatis.likes.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikeRequestDTO {

    @NotNull
    private int userId;

    @NotNull
    private int musicId;

}
