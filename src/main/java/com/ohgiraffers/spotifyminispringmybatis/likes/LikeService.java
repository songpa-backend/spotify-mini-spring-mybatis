package com.ohgiraffers.spotifyminispringmybatis.likes;

import com.ohgiraffers.spotifyminispringmybatis.common.exception.AlreadyLikedException;
import com.ohgiraffers.spotifyminispringmybatis.common.exception.CustomException;
import com.ohgiraffers.spotifyminispringmybatis.common.exception.LikeNotFoundException;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dao.LikeMapper;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeDTO;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeRequestDTO;
import com.ohgiraffers.spotifyminispringmybatis.likes.model.dto.LikeResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LikeService {

    private final LikeMapper likeMapper;

    public LikeService(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    public List<LikeDTO> selectLikesByUser(int userId) {
        return likeMapper.selectLikesByUser(userId);
    }

    @Transactional
    public LikeResponseDTO addLike(LikeRequestDTO request) {

        int count = likeMapper.selectLikeCount(request.getUserId(), request.getMusicId());

        if (count > 0) {
            throw new AlreadyLikedException("이미 좋아요 리스트에 추가된 곡입니다.");
        }

        LikeResponseDTO response = new LikeResponseDTO();
        response.setUserId(request.getUserId());
        response.setMusicId(request.getMusicId());

        int result = likeMapper.insertLike(response);

        if (result == 0) {
            throw new CustomException("좋아요 등록 중 오류가 발생했습니다.");
        }

        return response;
    }

    @Transactional
    public void removeLike(int likeId) {
        int result = likeMapper.removeLike(likeId);

        if (result == 0) {
            throw new LikeNotFoundException("좋아요 해제에 실패했습니다. (존재하지 않는 내역)");
        }
    }

}
