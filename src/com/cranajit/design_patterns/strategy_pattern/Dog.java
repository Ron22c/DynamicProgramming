package com.cranajit.design_patterns.strategy_pattern;

public class Dog extends Animal{

    public Dog() {
        super();
        setSound("BHOW");
        setFlyType(new CanNotFly());
    }

    public void digHole() {
        System.out.println("Digging Hole");
    }
}
