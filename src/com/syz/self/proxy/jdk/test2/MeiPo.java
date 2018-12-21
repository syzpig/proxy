package com.syz.self.proxy.jdk.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeiPo implements InvocationHandler{
	//引入被代理对象
	private Persion persion;
	//获取被代理人的个人资料
	public Object getIntersince(Persion persion) {
		this.persion=persion;
		//获取被代理对象类
		Class clazz=persion.getClass();
		System.out.println("获取被代理的对象"+clazz);
		//使用那个jdk动态代理重组生成动态对象
		Object obj=Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
		return obj;
	}
	
	//代理对象需要做的事
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("我是媒婆：" + "得给你找个异性才行");
		System.out.println("开始进行海选...");
		System.out.println("------------");
		
		method.invoke(this.persion, args);
		System.out.println("------------");
		System.out.println("如果合适的话，就准备办事");
		return null;
	}

}
