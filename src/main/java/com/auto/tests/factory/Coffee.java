package com.auto.tests.factory;

public class Coffee {

    String name = this.getClass().getSimpleName();

    public void grindCoffee() {
        System.out.println("I grind coffee");
    }

    public void makeCoffee() {
        System.out.println("I make coffee "+name);
    }

    public void pourCoffeeIntoCup() {
        System.out.println("I pour coffee into your cup");
    }
}
