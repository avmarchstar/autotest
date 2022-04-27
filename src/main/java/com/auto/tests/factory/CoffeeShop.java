package com.auto.tests.factory;


public class CoffeeShop {


    private final CoffeFactory coffeeFactory;

    public CoffeeShop(CoffeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }


    public Coffee createCoffee(CoffeeType coffeeType){

        Coffee coffee = coffeeFactory.createCoffee(coffeeType);

        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourCoffeeIntoCup();

        System.out.println("Here you are \n");

        return coffee;

    }





}
