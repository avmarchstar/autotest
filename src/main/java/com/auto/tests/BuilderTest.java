package com.auto.tests;

public class BuilderTest {

    private String str;
    private String str1;
    private String str2;
    private String str3;

    public static class Builder{
        private BuilderTest bt;

       public Builder(){
            bt = new BuilderTest();
        }

        public Builder setStr(String s){
            bt.str=s;
            return this;
        }

        public Builder setStr1(String s){
            bt.str1=s;
            return this;
        }

        public Builder setStr2(String s){
            bt.str2=s;
            return this;
        }

        public Builder setStr3(String s){
            bt.str3=s;
            return this;
        }

        public BuilderTest build(){
                   return bt;
        }

    }

    @Override
    public String toString() {

       return "BuilderTest{" +
                "str='" + str + '\'' +
                ", str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", str3='" + str3 + '\'' +
                '}';
    }
}
