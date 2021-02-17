package com.cranajit.design_patterns.strategy_pattern;

public class MainClass {
    public static void main(String[] args) {
        Animal doggy = new Dog();
        Animal birdy = new Bird();

        doggy.canFly();
        birdy.canFly();

        doggy.setFlyType(new CanFly());
        doggy.canFly();
    }
}
