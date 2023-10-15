package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlayListRepository;
import com.example.demo.repositories.ISongsRepository;

public class PlayListService {
    private final IPlayListRepository playListRepository;
    private final ISongsRepository songsRepository;

    public PlayListService(IPlayListRepository playListRepository,ISongsRepository songsRepository){
        this.playListRepository=playListRepository;
        this.songsRepository=songsRepository;
    }

    public PlayList createPlayList(String name,List<Integer> ids){
        //to check if all the songs asked are in the songs repository
        List<Song> songs=new ArrayList<>();
        
        for(Integer i: ids){
            Optional<Song> song=songsRepository.findById(i);
            if(song.get()==null){
                throw new RuntimeException();
            }
            songs.add(song.get());
        }
        PlayList playlist=new PlayList(name, songs);
        
        return playListRepository.save(playlist);
    }

    public PlayList deleteSongFromPlayList(String name, int songId){
        Optional<PlayList> optional =playListRepository.findByName(name);
        if(optional.get()==null){
            throw new RuntimeException();
        }
        Optional<Song> optionalSong= songsRepository.findById(songId);
        if(optionalSong.get()==null){
            throw new RuntimeException();
        }
        List<Song> songs=optional.get().getSongs();

        for(Song s : optional.get().getSongs()){
            if(s.getId()==songId){

                songs.remove(s);
                break;
            }
        }

        PlayList playList=new PlayList(name, songs, optional.get().getId());
        return playListRepository.save(playList);

    }

    public PlayList addSongToPlayList(String name, int songId){
        Optional<PlayList> optional =playListRepository.findByName(name);
        if(optional.get()==null){
            throw new RuntimeException();
        }
        Optional<Song> optionalSong= songsRepository.findById(songId);
        if(optionalSong.get()==null){
            throw new RuntimeException();
        }
        for(Song s : optional.get().getSongs()){
            if(s.getId()==songId){
                return optional.get();
            }
        }
        List<Song> songs=optional.get().getSongs();
        songs.add(optionalSong.get());
        PlayList playList=new PlayList(name, songs, optional.get().getId());
        return playListRepository.save(playList);
    }

    public void deletePlayList(String name){
        Optional<PlayList> optional =playListRepository.findByName(name);
        if(optional.get()==null){
            return;
        }
        playListRepository.delete(optional.get().getId());

    }
    
    
}
