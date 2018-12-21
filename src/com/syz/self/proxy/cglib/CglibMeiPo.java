package com.syz.self.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//MethodInterceptor方法拦截器，也就是aop拦截方法.
//实现MethodInterceptor 接口，在调用目标对象的方法时，就可以实现在调用方法之前、调用方法过程中、调用方法之后对其进行控制。
public class CglibMeiPo implements MethodInterceptor{

	//這一步。沒有了，被代理對象的引用，cglib自動生成子類
	public Object getInstance(Class clazz)throws Exception{
		//Proxy是基于接口的方式进行代理，Enhancer是基于继承的方式代理。 
		//Enhancer动态创建了给定类型的子类但是拦截了所有的方法。和Proxy不一样的是，不管是接口还是类他都能正常工作。
		Enhancer enhancer =new Enhancer();
		//这一步就是告诉cglib,生成的子类需要继承那个类
		enhancer.setSuperclass(clazz);
		//设置回调  回调执行intercept方法对目标对象功能的增强 this就只下面当前对象的intercept方法
		//因此只要有方法调用就会执行intercept这个方法，然后去执行需要出来的方法proxy.invokeSuper(obj, arg2)，再此我们
		//就可以在这个方法前后加入我们的一些处理增强
		enhancer.setCallback(this);
		
		//第一步、生成源代碼
		//第二步、编译成class文件
		//第三步、加载jvm中，并返回被代理对象
		return enhancer.create();
	}
	
	//同样是做了字节码重组这样一件事
	//对于使用API的用户来说，是无感知的
	
	//Method参数，作用是拿到调用的方法
	@Override
	public Object intercept(Object obj, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("我是GP媒婆：" + "得给你找个异性才行");
		System.out.println("开始进行海选...");
		System.out.println("------------");
		//这个obj的引用是由CGLIB给我们new出来的
		//cglib new 出来以后的对象，就是被代理对象的子类(继承了我们自己写的那个类）
		//OOP中规定,在new子类之前，实际上默认先调用了我们super方法的，
		//也就是说new了子类的同时，必须先new出来父类，这就相当于是间接地持有了我们父类的引用 （这就跟jdk接口引用一样都符合动态代理的特点，这个引用不是我们new，而是cglibnew的，只需要我们传个类就行）
		//子类重写了父类的所有的方法
		//我们改变子类的某些属性，是可以间接的操作父类的属性的。
		proxy.invokeSuper(obj, arg2);//需要调用父类的方法，invoke这个是子类的，会造成死循环
		//因为这个obj使我们子类的引用，在子类的引用中调用子类的引用，就会调intercept，
		//，就相当在findLove()方法中调用findLove（）方法.掉用super就是调用我们自己写的代码，而调用子类的就代理后的新代码，并不是我们的代码，
		System.out.println("------------");
		System.out.println("如果合适的话，就准备办事");
		return null;
	}
  
}
