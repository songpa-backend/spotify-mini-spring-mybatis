package com.ohgiraffers.spotifyminispringmybatis.music.model.dao;

import com.ohgiraffers.spotifyminispringmybatis.music.model.dto.MusicDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MusicMapper {

    List<MusicDTO> findAllMusics();

    MusicDTO findMusicById(@Param("musicId") int musicId);
}
