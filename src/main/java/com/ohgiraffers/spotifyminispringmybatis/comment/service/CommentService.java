package com.ohgiraffers.spotifyminispringmybatis.comment.service;

import com.ohgiraffers.spotifyminispringmybatis.comment.model.dao.CommentMapper;
import com.ohgiraffers.spotifyminispringmybatis.comment.model.dto.CommentDTO;
import com.ohgiraffers.spotifyminispringmybatis.music.model.dto.MusicDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public List<CommentDTO> findCommentsByUserAndMusic(int userId, int musicId) {

        return commentMapper.findCommentsByUserAndMusic(userId, musicId);
    }
    @Transactional
    public CommentDTO registComment(CommentDTO newComment) {
        commentMapper.registComment(newComment);
        return newComment;
    }
}
