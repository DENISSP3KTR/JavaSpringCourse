package ru.osipov.redisspring.repository;

import ru.osipov.redisspring.model.Movie;

import java.util.Map;

public interface RedisRepository {
    Map<Object, Object> findAllMovies();
    void add(Movie movie);
    void delete(String id);
    Movie findMovie(String id);
}
