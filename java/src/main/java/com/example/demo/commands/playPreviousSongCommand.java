package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.SongDto;
import com.example.demo.services.Player;

public class playPreviousSongCommand implements ICommand {

    private final Player player;
    

    public playPreviousSongCommand(Player player) {
        this.player = player;
    }


    @Override
    public void invoke(List<String> tokens) {
        SongDto songdto = player.previous();
        //Song [id=2] is stopped!
        System.out.println(songdto.getSong()+" is playing!");

    }
    
}
