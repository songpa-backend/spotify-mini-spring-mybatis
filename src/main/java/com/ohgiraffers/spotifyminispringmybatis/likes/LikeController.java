package com.ohgiraffers.spotifyminispringmybatis.likes;

import com.ohgiraffers.spotifyminispringmybatis.common.ResponseMessage;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeDTO;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeRequestDTO;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favorites")
public class LikeController {

    private final ObjectMapper mapper = new ObjectMapper();
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public ResponseEntity<ResponseMessage> selectLikesByUser(@RequestParam int userId) {
        List<LikeDTO> likeDTOS = likeService.selectLikesByUser(userId);

        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .status(200)
                        .message("좋아요 목록 조회 성공")
                        .results(
                                Map.of("likes", likeDTOS)
                        )
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> addLike(@RequestBody @Valid LikeRequestDTO requestDTO) {

        LikeResponseDTO likeResponseDTO = likeService.addLike(requestDTO);

        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .status(200)
                        .message("좋아요 등록 성공")
                        .results(
                                Map.of("like", likeResponseDTO)
                        )
                        .build()
        );
    }

    @DeleteMapping
    public ResponseEntity<ResponseMessage> removeLike(@RequestParam int likeId) {

        likeService.removeLike(likeId);

        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .status(200)
                        .message("좋아요 해제 성공")
                        .results(
                                Map.of("deletedLikeId", likeId)
                        )
                        .build()
        );
    }
}
