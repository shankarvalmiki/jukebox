package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.PlayList;

public class PlayListRepository implements IPlayListRepository{
    private final Map<Integer, PlayList> playListMap;
    private Integer autoIncrement=1;

    public PlayListRepository(){
        this.playListMap=new HashMap<Integer, PlayList>();
    }

    @Override
    public PlayList save(PlayList playlist) {
        if(playlist.getId()==null){
        PlayList playList=new PlayList(playlist.getName(), playlist.getSongs(),autoIncrement);
        playListMap.put(autoIncrement,playList);
        autoIncrement++;
        
        return playList;
        }
        playListMap.put(playlist.getId(),playlist);
        return playlist;

    }

    

    @Override
    public List<PlayList> findAll(){
        
        return playListMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<PlayList> findById(Integer id) {
        
        return Optional.ofNullable(playListMap.get(id));
    }
    @Override
    public Optional<PlayList> findByName(String name){
        for(PlayList p:playListMap.values()){
            if(p.getName().equals(name)){
                return Optional.ofNullable(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        playListMap.remove(id);
        
    }
    
    
}
