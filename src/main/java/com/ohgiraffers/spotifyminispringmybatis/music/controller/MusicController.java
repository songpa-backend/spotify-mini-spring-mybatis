package com.ohgiraffers.spotifyminispringmybatis.music.controller;

import com.ohgiraffers.spotifyminispringmybatis.comment.model.dto.CommentDTO;
import com.ohgiraffers.spotifyminispringmybatis.music.model.dto.MusicDTO;
import com.ohgiraffers.spotifyminispringmybatis.music.service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/musics")
    public ResponseEntity<List<MusicDTO>> findMusicList() {
        return ResponseEntity.ok(musicService.findAllMusics());
    }

    //http://localhost:3000/music/15
    @GetMapping("/musics/{musicId}")
    public ResponseEntity<MusicDTO> findMusicById(@PathVariable int musicId) {
        MusicDTO music = musicService.findMusicById(musicId);

        if(music == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(music);
    }


}
