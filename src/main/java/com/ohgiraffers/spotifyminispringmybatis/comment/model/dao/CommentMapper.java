package com.ohgiraffers.spotifyminispringmybatis.comment.model.dao;

import com.ohgiraffers.spotifyminispringmybatis.comment.model.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentDTO> findCommentsByUserAndMusic(@Param("userId") int userId, @Param("musicId") int musicId);

    int registComment(CommentDTO newComment);
}
