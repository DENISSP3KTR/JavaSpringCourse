package ru.osipov.redisspring.queue;

public interface MessagePublisher {
    void publish(final String message);
}
