package ru.osipov.spring;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Mozart";
    }
}
