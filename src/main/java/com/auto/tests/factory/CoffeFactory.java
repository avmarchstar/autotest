package com.auto.tests.factory;

public class CoffeFactory {


    public Coffee createCoffee(CoffeeType coffeeType){

        Coffee coffee=null;

        switch (coffeeType){
            case AMERICANO:coffee=new Americano();break;
            case ESPRESSO:coffee=new Espresso();break;
            case CAFFE_LATTE:coffee=new Latte();break;
            case CAPPUCCINO:coffee=new Cappuccino();break;
            default:
                System.out.println("I don't know this type of coffee");break;

        }
                return coffee;
    }

}
