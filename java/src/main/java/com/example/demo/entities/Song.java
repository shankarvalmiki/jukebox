package com.example.demo.entities;

public class Song {
    private final String name;
    private final String artistOrBand;
    private final String Album;
    private final String genre;
    private final Integer id;

    public Song(String name, String artistOrBand, String Album, String genre, int id){
        this.name=name;
        this.artistOrBand=artistOrBand;
        this.Album=Album;
        this.genre=genre;
        this.id=id;
    }
    
    public Song(String name, String artistOrBand,String Album, String genre){
        this.name=name;
        this.artistOrBand=artistOrBand;
        this.Album=Album;
        this.genre=genre;
        this.id=null;
        
    }

    public String getName(){
        return this.name;
    }

    public String getArtistName(){
        return this.artistOrBand;
    }

    public String getAlbum(){
        return this.Album;
    }

    public String getGenre(){
        return this.genre;
    }
    public int getId(){
        return this.id;
    }
     //Song [id=1]

    @Override
    public String toString() {
        return "Song [id=" + id + "]";
    }
     
}
