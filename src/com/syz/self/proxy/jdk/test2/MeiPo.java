package com.syz.self.proxy.jdk.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeiPo implements InvocationHandler{
	//���뱻�������
	private Persion persion;
	//��ȡ�������˵ĸ�������
	public Object getIntersince(Persion persion) {
		this.persion=persion;
		//��ȡ�����������
		Class clazz=persion.getClass();
		System.out.println("��ȡ������Ķ���"+clazz);
		//ʹ���Ǹ�jdk��̬�����������ɶ�̬����
		Object obj=Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
		return obj;
	}
	
	//���������Ҫ������
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("����ý�ţ�" + "�ø����Ҹ����Բ���");
		System.out.println("��ʼ���к�ѡ...");
		System.out.println("------------");
		
		method.invoke(this.persion, args);
		System.out.println("------------");
		System.out.println("������ʵĻ�����׼������");
		return null;
	}

}
