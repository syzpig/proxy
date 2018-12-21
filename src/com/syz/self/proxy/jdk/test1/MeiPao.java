package com.syz.self.proxy.jdk.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//������ Ҫʵ��jdk��̬����ʽ   InvocationHandlerʵ�ִ���ӿ�
public class MeiPao implements InvocationHandler {

	// ����������������Ϊһ����Ա������������
	private Persion persion;

	// ��ȡ�������˵ĸ�������
	public Object getInstance(Persion persion) {
		this.persion = persion;
		// ��ӡ�±�����Ķ���
		Class clazz = persion.getClass();
		System.out.println("�������õ����������" + clazz);
		// ͨ�����䣺��ʼ����һ���������ȥ����������������(�����ֽ������������µĴ������)
		// ��Ҫ���ص��ࣨClassLoader loader��Ŀ�����������������
		// �ӿ� (Class<?>[] interfaces��Ŀ�����Ľӿ�����)��
		// ��ǰ�������(�¼���������ʵ�ֶ�Ŀ�����Ĳ�����)
		Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
		return obj;
	}

	//���������Ҫ���·���  
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("����ý�ţ�" + "�ø����Ҹ����Բ���");
		System.out.println("��ʼ���к�ѡ...");
		System.out.println("------------");
		
		
		//���õ�ʱ���÷�����Ƶ��ñ������˷���
		method.invoke(this.persion, args);  //=this.persion.findLove();
		
		
		System.out.println("------------");
		System.out.println("������ʵĻ�����׼������");
		return null;
	}

}
