package com.cranajit.design_patterns.strategy_pattern;

public class Animal {
    private String name;
    private String sound;
    private Fly flyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void canFly() {
        flyType.doFly();
    }

    public void setFlyType(Fly flyType) {
        this.flyType = flyType;
    }
}
