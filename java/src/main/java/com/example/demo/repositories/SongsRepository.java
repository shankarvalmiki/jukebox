package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongsRepository implements ISongsRepository{
    private final Map<Integer,Song> songMap;
    private Integer autoIncrement=1;


    public SongsRepository(){
        this.songMap=new HashMap<Integer,Song>();
    }

    @Override
    public Song save(Song song) {
       Song newSong= new Song(song.getName(), song.getArtistName(), song.getAlbum(), song.getGenre(), autoIncrement);
       songMap.put(autoIncrement,newSong);
       autoIncrement++;

        return newSong;
    }

    @Override
    public List<Song> findAll() {
       // List<Song> allSongs= new ArrayList<>();
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Song> findById(Integer id) {
       return Optional.ofNullable(songMap.get(id));
       
    }
    

    
}
