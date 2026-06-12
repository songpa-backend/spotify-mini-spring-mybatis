package com.ohgiraffers.spotifyminispringmybatis.music.service;

import com.ohgiraffers.spotifyminispringmybatis.music.model.dao.MusicMapper;
import com.ohgiraffers.spotifyminispringmybatis.music.model.dto.MusicDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    private final MusicMapper musicMapper;

    public MusicService(MusicMapper musicMapper){ this.musicMapper = musicMapper; }

    public  List<MusicDTO> findAllMusics() {
        return musicMapper.findAllMusics();
    }

    public MusicDTO findMusicById(int musicId) { return musicMapper.findMusicById(musicId); }
}
