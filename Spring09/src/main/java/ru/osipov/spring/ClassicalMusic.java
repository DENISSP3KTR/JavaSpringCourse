package ru.osipov.spring;

import org.springframework.stereotype.Component;

@Component("musicBean")
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Mozart";
    }
}
