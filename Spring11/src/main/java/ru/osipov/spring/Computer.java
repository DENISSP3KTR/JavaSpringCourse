package ru.osipov.spring;

import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer){
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString(){
        return "Comp " + id + " " + musicPlayer.playMusic();
    }
}
