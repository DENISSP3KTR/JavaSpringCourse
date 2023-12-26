package ru.osipov.spring;

public class ClassicalMusic implements Music {
    private ClassicalMusic() {}

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    public void doMyInit(){
        System.out.println("Init sdelay");
    }
    public void doMyDestroy(){
        System.out.println("Destroy sdelay");
    }

    @Override
    public String getSong() {
        return "Mozart";
    }
}
