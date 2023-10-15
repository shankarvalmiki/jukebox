package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongsRepository;

public class SongService {
    private final ISongsRepository songRepository;


    public SongService(ISongsRepository songRepository){
        this.songRepository=songRepository;
    }

    public Song addSong(String name, String artistOrBand,String Album,String genre){
        Song song = new Song(name, artistOrBand, Album, genre);
        return songRepository.save(song);
    }

    public List<Song> getListOfSongs(){
        return songRepository.findAll();
    }
}
