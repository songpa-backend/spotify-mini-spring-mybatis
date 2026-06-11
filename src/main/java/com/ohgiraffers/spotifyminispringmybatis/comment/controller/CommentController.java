package com.ohgiraffers.spotifyminispringmybatis.comment.controller;

import com.ohgiraffers.spotifyminispringmybatis.comment.model.dto.CommentDTO;
import com.ohgiraffers.spotifyminispringmybatis.comment.service.CommentService;
import com.ohgiraffers.spotifyminispringmybatis.common.ResponseMessage;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeRequestDTO;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeResponseDTO;
import com.ohgiraffers.spotifyminispringmybatis.music.model.dto.MusicDTO;
import com.ohgiraffers.spotifyminispringmybatis.music.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

            List<CommentDTO> comments = commentService.findCommentsByUserAndMusic(userId, musicId);
            return ResponseEntity.ok(comments);
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentDTO> registComment(@RequestBody CommentDTO commentDTO) {

        CommentDTO registComment = commentService.registComment(commentDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(registComment);
//        return ResponseEntity.ok(
//                ResponseMessage.builder()
//                        .status(200)
//                        .message("댓글 등록 성공")
//                        .results(
//                                Map.of("comment", registComment)
//                        )
//                        .build()
//        );
    }


}
