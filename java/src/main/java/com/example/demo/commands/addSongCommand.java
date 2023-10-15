package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;


public class addSongCommand implements ICommand {

    private final SongService songService;

    public addSongCommand(SongService songService){
        this.songService=songService;
    }

    @Override
    public void invoke(List<String> tokens) {

        String name=tokens.get(0);
        String artistOrBand=tokens.get(1);
        String Album=tokens.get(2);
        String genre=tokens.get(3);

        Song song= songService.addSong(name, artistOrBand, Album, genre);
        System.out.println(song);
    }
    
    
}
