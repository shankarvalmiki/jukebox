package com.example.demo.entities;

import java.util.List;

public class PlayList {
    private final String name;
    private final List<Song> songs;
    private final Integer id;

    public PlayList(String name, List<Song> songs, int id){
        this.name=name;
        this.songs=songs;
        this.id=id;
    }

    public PlayList(String name, List<Song> songs){
        this.name=name;
        this.songs=songs;
        this.id=null;
    }

    public String getName(){
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Integer getId() {
        return id;
    }
    
    //Playlist [id=1]
    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
    


    

}
