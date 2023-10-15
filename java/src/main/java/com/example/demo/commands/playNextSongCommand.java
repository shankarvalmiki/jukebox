package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.CurrentState;
import com.example.demo.entities.SongDto;
import com.example.demo.services.Player;

public class playNextSongCommand implements ICommand {

    private final Player player;
    

    public playNextSongCommand(Player player) {
        this.player = player;
    }


    @Override
    public void invoke(List<String> tokens) {

        SongDto songdto=player.next();
        if(songdto.getCurrentState()==CurrentState.PLAYING){
            //Song [id=4] is playing!
            System.out.println(songdto.getSong()+" is playing!");
        }
    }

    
}
