package ru.osipov.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music{
    private List<String> enumSomgs = new ArrayList<>();
    {
        enumSomgs.add("Dora");
        enumSomgs.add("HeavyRain");
        enumSomgs.add("Ramstain");
    }
    @Override
    public List<String> getSongs()
    {
        return enumSomgs;
    }
}
