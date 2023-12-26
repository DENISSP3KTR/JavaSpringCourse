package ru.osipov.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music{
    private List<String> enumSomgs = new ArrayList<>();
    {
        enumSomgs.add("Mozart");
        enumSomgs.add("Bethoven");
        enumSomgs.add("Chaykovskiy");
    }
    @Override
    public List<String> getSongs()
    {
        return enumSomgs;
    }
}
