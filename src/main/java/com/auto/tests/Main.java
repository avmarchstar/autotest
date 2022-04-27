package com.auto.tests;

import com.auto.tests.factory.CoffeFactory;
import com.auto.tests.factory.CoffeeShop;
import com.auto.tests.factory.CoffeeType;

public class Main {

    public static void main(String[] args) {

//        --------------Singleton
//        Singleton sngl = Singleton.getInstance();
//        Singleton sngl1 = Singleton.getInstance();
//        sngl.setStr("1");
//        sngl1.setStr("2");
//        System.out.println(sngl==sngl1);
//        System.out.println(sngl.toString()+" "+sngl.hashCode());
//        System.out.println(sngl1.toString()+" "+sngl1.hashCode());
//
////      --------------Builder
//        BuilderTest bt = new BuilderTest.Builder().setStr1("1").build();
//        BuilderTest bt1 = new BuilderTest.Builder().setStr1("1").setStr3("3").setStr("0").build();
//        System.out.println(bt);
//        System.out.println(bt1);


//        --------------Factory

        CoffeeShop coffeeShop = new CoffeeShop(new CoffeFactory());
        coffeeShop.createCoffee(CoffeeType.AMERICANO);
        coffeeShop.createCoffee(CoffeeType.CAFFE_LATTE);







    }
}
