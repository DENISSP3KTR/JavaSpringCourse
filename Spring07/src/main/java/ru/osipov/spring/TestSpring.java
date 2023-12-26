package ru.osipov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ///Music music = context.getBean("musicBean", Music.class);

        ///MusicPlayer musicPlayer = new MusicPlayer(music);

        MusicPlayer firstmusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondmusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comprison = firstmusicPlayer == secondmusicPlayer;
        ///musicPlayer.playMusicList();
        System.out.println(comprison);

        System.out.println(firstmusicPlayer);
        System.out.println(secondmusicPlayer);
        firstmusicPlayer.setVolume(10);
        System.out.println(firstmusicPlayer.getVolume());
        System.out.println(secondmusicPlayer.getVolume());
//        System.out.println(musicPlayer.getName());
//        System.out.println(musicPlayer.getVolume());
        context.close(); 
    }
}
