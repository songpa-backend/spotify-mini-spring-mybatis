package com.ohgiraffers.spotifyminispringmybatis.likes.model.dao;

import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeDTO;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeResponseDTO;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {

    List<LikeDTO> selectLikesByUser(int userId);

    int insertLike(LikeResponseDTO response);

    int removeLike(int likeId);

    int selectLikeCount(@NotNull int userId, @NotNull int musicId);
}
