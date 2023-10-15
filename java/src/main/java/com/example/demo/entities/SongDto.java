package com.example.demo.entities;

public class SongDto {
    private Song song;
    private CurrentState currentState;

    public SongDto(Song song, CurrentState currentState){
        this.currentState=currentState;
        this.song=song;
    }

    public  SongDto(CurrentState currentState){
        this.currentState=currentState;
        this.song=null;

    }

    public Song getSong() {
        return song;
    }

    public CurrentState getCurrentState() {
        return currentState;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public void setCurrentState(CurrentState currentState) {
        this.currentState = currentState;
    }

}
