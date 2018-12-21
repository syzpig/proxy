package com.syz.self.proxy.jdk.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理人 要实现jdk动态代理方式   InvocationHandler实现代理接口
public class MeiPao implements InvocationHandler {

	// 被代理对象的引用作为一个成员变量保存下来
	private Persion persion;

	// 获取被代理人的个人资料
	public Object getInstance(Persion persion) {
		this.persion = persion;
		// 打印下被代理的对象
		Class clazz = persion.getClass();
		System.out.println("代理人拿到被代理对象" + clazz);
		// 通过反射：开始创建一个代理对象去操作这个被代理对象(重组字节码重新生成新的代理对象)
		// 需要加载的类（ClassLoader loader：目标对象的类加载器）、
		// 接口 (Class<?>[] interfaces：目标对象的接口类型)、
		// 当前代理对象(事件处理函数，实现对目标对象的操作。)
		Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
		return obj;
	}

	//代理对象处理要做事方法  
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("我是媒婆：" + "得给你找个异性才行");
		System.out.println("开始进行海选...");
		System.out.println("------------");
		
		
		//调用的时候用反射机制调用被代理人方法
		method.invoke(this.persion, args);  //=this.persion.findLove();
		
		
		System.out.println("------------");
		System.out.println("如果合适的话，就准备办事");
		return null;
	}

}
