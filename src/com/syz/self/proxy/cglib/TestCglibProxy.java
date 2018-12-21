package com.syz.self.proxy.cglib;

import com.gupaoedu.vip.proxy.cglib.GPMeipo;
import com.gupaoedu.vip.proxy.cglib.YunZhongYu;

public class TestCglibProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//jdk的动态代理是通过接口来进行强制转换的
		//生成以后的代理对象，可以强制转化为接口
		
		
		//CGLIB的动态代理是通过生成一个被代理对象的子类，然后重写父类的方法（默认会重写所有父类的方法）
		//生成以后的对象，可以强制转换为被代理对象，（也就是用自己写的类）
		//子类引用赋值给父类
		
		
		try {
			//jdk中介引用被代理对象操作，在cglib这个引用不是我们new，而是cglibnew的，只需要我们传个类就行
			YunZhongYu obj = (YunZhongYu)new GPMeipo().getInstance(YunZhongYu.class);
			obj.findLove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
