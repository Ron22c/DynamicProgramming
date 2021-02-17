package com.cranajit.design_patterns.strategy_pattern;

public class Bird extends Animal {
    public Bird() {
        setSound("TWEET");
        setFlyType(new CanFly());
    }
}
