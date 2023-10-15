package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.Player;

public class LoadPlayListCommand implements ICommand {
    private final Player player;
    

    public LoadPlayListCommand(Player player) {
        this.player = player;
    }


    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        player.load(name);
        //Playlist PLAYLIST_2 is loaded!
        System.out.println("Playlist "+tokens.get(1)+" is loaded!");
        
    }
    
    
}
