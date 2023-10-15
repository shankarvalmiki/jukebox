package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.PlayList;
import com.example.demo.services.PlayListService;

public class addSongToPLayListCommand implements ICommand {

    private final PlayListService playListService;

    
    public addSongToPLayListCommand(PlayListService playListService) {
        this.playListService = playListService;
    }


    @Override
    public void invoke(List<String> tokens) {

        String name = tokens.get(1);
        int songId=Integer.parseInt(tokens.get(2));
        
        PlayList playList=playListService.addSongToPlayList(name, songId);
        //Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=9], Song [id=8]]
        System.out.println("Playlist "+playList.getName()+" is revised with "+playList.getSongs());
    }
    
}
