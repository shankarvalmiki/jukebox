package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.CurrentState;
import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.entities.SongDto;
import com.example.demo.repositories.IPlayListRepository;

public class Player {
    private IPlayListRepository playListRepository;

    private CurrentState currentState=CurrentState.IDLE;
    private List<Song> currentSongs;
    private PlayList currentPlayList;
    private Song currentSong;
    
    public Player(IPlayListRepository playListRepository){
        this.playListRepository=playListRepository;
    }

    public String load(String name){
        Optional<PlayList> optional= playListRepository.findByName(name);
        PlayList playlist = optional.get();
        this.currentPlayList=playlist;
        this.currentSongs=playlist.getSongs();
        this.currentSong=currentSongs.get(0);
        return playlist.getName();
    }

    public SongDto play(){
        //when player is idle
        if(currentState==CurrentState.IDLE){
            //when player is idle and no playlist is loaded.
            if(currentPlayList==null){
                SongDto res=new SongDto(currentState);
                return res;
            }
            //when  player is idle and playlist is loaded.
            currentState=CurrentState.PLAYING;
            SongDto res= new SongDto(currentSong, currentState);
            return res;   
            
        }
        //when player is paused - play() should continue playing the current song.
        if(currentState==CurrentState.PAUSED){
            currentState=CurrentState.PLAYING;
            SongDto res= new SongDto(currentSong, currentState);
            return res;

        }

        //when current state is playing the play() should pause the song playing
            currentState=CurrentState.PAUSED;
            SongDto res=new SongDto(currentSong,currentState);
            return res;
        
    }

    public SongDto next(){
        //when currentState is idle then next() will not do anything
        if(currentState==CurrentState.IDLE){
            SongDto res=new SongDto(currentState);
            return res;
        }
        //when current state is paused or playing 
        int ind = currentSongs.indexOf(currentSong);
        currentState=CurrentState.PLAYING;
        //if currentstate is paused and the paused song is last song then the player plays the first song
        if(ind==currentSongs.size()-1){
            
            currentSong=currentSongs.get(0);
            SongDto res=new SongDto(currentSong,currentState);
            return res;
        }
        currentSong=currentSongs.get(ind+1);
        return new SongDto(currentSong, currentState);

        //currentState is playing
        



    }
    public SongDto previous(){
        if(currentState==CurrentState.IDLE){
            SongDto res=new SongDto(currentState);
            return res;
        }
        //when current state is paused or playing 
        int ind = currentSongs.indexOf(currentSong);
        currentState=CurrentState.PLAYING;
        // if the current song is the first song in the playlist then the previous() should play the last song in the playlist
        if(ind==0){
            
            currentSong=currentSongs.get(currentSongs.size()-1);
            SongDto res=new SongDto(currentSong,currentState);
            return res;
        }
        currentSong=currentSongs.get(ind-1);
        return new SongDto(currentSong, currentState);

    }

    public SongDto stop(){
        currentState=CurrentState.IDLE;
        SongDto songdto= new SongDto(currentSong, currentState);
        return songdto;

    }

}
