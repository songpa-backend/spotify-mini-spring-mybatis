package com.ohgiraffers.spotifyminispringmybatis.comment.controller;

import com.ohgiraffers.spotifyminispringmybatis.comment.model.dto.CommentDTO;
import com.ohgiraffers.spotifyminispringmybatis.comment.service.CommentService;
import com.ohgiraffers.spotifyminispringmybatis.music.model.dto.MusicDTO;
import com.ohgiraffers.spotifyminispringmybatis.music.service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    //http://localhost:3000/api/comments?userId=1&musicId=15
    @GetMapping("/comments")
    public  ResponseEntity<List<CommentDTO>> findsAllComments(@RequestParam int userId, @RequestParam int musicId){

        if(userId != -1 && musicId != -1){
            List<CommentDTO> comments = commentService.findCommentsByUserAndMusic(userId, musicId);
            return ResponseEntity.ok(comments);
        }
        else if(userId == -1 || musicId == -1){
            //
        }
        return null;
    }


}
