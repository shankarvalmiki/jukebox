package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.CurrentState;
import com.example.demo.entities.SongDto;
import com.example.demo.services.Player;

public class playSongCommand implements ICommand{
    private final Player player;


    public playSongCommand(Player player){
        this.player=player;
    }

    @Override
    public void invoke(List<String> tokens) {

        SongDto songdto = player.play();
        if(songdto.getCurrentState()==CurrentState.IDLE){
            return;
        }
        if(songdto.getCurrentState()==CurrentState.PAUSED){
            System.out.println(songdto.getSong()+" is paused!");
            return;
        }
        System.out.println(songdto.getSong()+" is playing!");


        
        
    }
    
}
