package com.auto.tests;

class Singleton {

    private String str="str";

    static Singleton sngl;
    private Singleton(){}

    public void setStr(String str) {
        this.str = str;
    }

    public static Singleton getInstance(){
        if (sngl==null){sngl = new Singleton();}
        return sngl;
    }


    @Override
    public String toString() {
        return "Singleton{" +
                "str= '" + str +"' }";
    }
}
