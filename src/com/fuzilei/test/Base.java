package com.fuzilei.test;
//∏∏¿‡
public class Base {
	private String name = "base";
	 
    public Base() {
        tellName();
        printName();
        testName();
    }
 
    public void tellName() {
        System.out.println("Base tell name: " + name);
    }
 
    public void printName() {
        System.out.println("Base print name: " + name);
    }
 
    public void testName() {
        System.out.println("Base testName is:" + name);
    }


}
