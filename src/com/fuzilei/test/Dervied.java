package com.fuzilei.test;
//子类
public class Dervied extends Base {
	private String name = "dervied";
	 
    public Dervied() {
        tellName();
        printName();
    }
 
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }
 
    public void printName() {
        System.out.println("Dervied print name: " + name);
    }
 
    public static void main(String[] args){
    	//子类是创建之时，默认存在一个super()在子类构造方法里面，如果你显示将其写在第一行，也不会报错，
    	//但是不可将其放置在第一行之外的行中，那样编译器会直接报错。如果不能理解，可以这么想，
    	//你想创建一个子类，那你的父类得有吧！如果父类都没有，那怎么创建你的子类？毕竟你的子类是依据父类来的。
    	
    	//类继承时构造器的调用顺序和初始化顺序。要记住一点：父类的构造器调用以及初始化过程一定在子类的前面
        new Dervied();
        
        //https://blog.csdn.net/qq_32409957/article/details/80927138
    }


}
