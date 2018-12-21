package com.fuzilei.test.yincanghefugai;

public class Circle extends Shape {
	public String name = "circle";

	public Circle() {
		System.out.println("circle constructor");
	}

	public void printType() {
		System.out.println("this is circle");
	}

	public static void printName() {
		System.out.println("circle");
	}
}
