package com.cranajit.design_patterns.strategy_pattern;

public interface Fly {
    void doFly();
}

class CanFly implements Fly{

    @Override
    public void doFly() {
        System.out.println("I CAN FLY");
    }
}

class CanNotFly implements Fly {

    @Override
    public void doFly() {
        System.out.println("I CAN't FLY");
    }
}
