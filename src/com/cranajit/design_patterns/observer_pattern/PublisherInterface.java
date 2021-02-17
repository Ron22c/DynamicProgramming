package com.cranajit.design_patterns.observer_pattern;

public interface PublisherInterface {
    void register(Observer o);
    void unRegister(Observer o);
    void sendNotification();
}
