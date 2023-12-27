package ru.osipov.kafka;

import ru.osipov.kafka.StarshipDto;

public interface StarshipService {

    StarshipDto save(StarshipDto dto);

    void send(StarshipDto dto);

    void consume(StarshipDto dto);
}