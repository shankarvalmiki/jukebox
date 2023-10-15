package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.PlayList;
import com.example.demo.services.PlayListService;

public class createPlayListCommand implements ICommand {

    private PlayListService playListService;

    public createPlayListCommand(PlayListService playListService){
        this.playListService=playListService;
    }

    @Override
    public void invoke(List<String> tokens) {

        String name =tokens.get(1);
        List<Integer> ids= new ArrayList<>();
        for(int i=2;i<tokens.size();i++){
            String s = tokens.get(i);
            int songid=Integer.parseInt(s);
            ids.add(songid);
            //ids.add(Integer.parseInt(tokens.get(i)));
        }
        
       PlayList playlist= playListService.createPlayList(name, ids);
       System.out.println(playlist);
        
    }
    
}
