package com.ohgiraffers.spotifyminispringmybatis.music.controller;

import com.ohgiraffers.spotifyminispringmybatis.music.model.dto.MusicDTO;
import com.ohgiraffers.spotifyminispringmybatis.music.service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService){ this.musicService = musicService; }

    @GetMapping("/musics")
    public ResponseEntity<List<MusicDTO>> findMusicList(){
        return ResponseEntity.ok(musicService.findAllMusics());
    }

}
