package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlayListService;

public class deletePlayListCommand implements ICommand{
    private final PlayListService playListService;
    

    public deletePlayListCommand(PlayListService playListService) {
        this.playListService = playListService;
    }


    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);

        playListService.deletePlayList(name);
        //Playlist PLAYLIST_1 is deleted!
        System.out.println("Playlist "+name+" is deleted!");
        
        
    }
    
    
}
