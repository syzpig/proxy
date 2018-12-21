package com.syz.self.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//MethodInterceptor������������Ҳ����aop���ط���.
//ʵ��MethodInterceptor �ӿڣ��ڵ���Ŀ�����ķ���ʱ���Ϳ���ʵ���ڵ��÷���֮ǰ�����÷��������С����÷���֮�������п��ơ�
public class CglibMeiPo implements MethodInterceptor{

	//�@һ�����]���ˣ������팦������ã�cglib�Ԅ��������
	public Object getInstance(Class clazz)throws Exception{
		//Proxy�ǻ��ڽӿڵķ�ʽ���д���Enhancer�ǻ��ڼ̳еķ�ʽ���� 
		//Enhancer��̬�����˸������͵����൫�����������еķ�������Proxy��һ�����ǣ������ǽӿڻ���������������������
		Enhancer enhancer =new Enhancer();
		//��һ�����Ǹ���cglib,���ɵ�������Ҫ�̳��Ǹ���
		enhancer.setSuperclass(clazz);
		//���ûص�  �ص�ִ��intercept������Ŀ������ܵ���ǿ this��ֻ���浱ǰ�����intercept����
		//���ֻҪ�з������þͻ�ִ��intercept���������Ȼ��ȥִ����Ҫ�����ķ���proxy.invokeSuper(obj, arg2)���ٴ�����
		//�Ϳ������������ǰ��������ǵ�һЩ������ǿ
		enhancer.setCallback(this);
		
		//��һ��������Դ���a
		//�ڶ����������class�ļ�
		//������������jvm�У������ر��������
		return enhancer.create();
	}
	
	//ͬ���������ֽ�����������һ����
	//����ʹ��API���û���˵�����޸�֪��
	
	//Method�������������õ����õķ���
	@Override
	public Object intercept(Object obj, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("����GPý�ţ�" + "�ø����Ҹ����Բ���");
		System.out.println("��ʼ���к�ѡ...");
		System.out.println("------------");
		//���obj����������CGLIB������new������
		//cglib new �����Ժ�Ķ��󣬾��Ǳ�������������(�̳��������Լ�д���Ǹ��ࣩ
		//OOP�й涨,��new����֮ǰ��ʵ����Ĭ���ȵ���������super�����ģ�
		//Ҳ����˵new�������ͬʱ��������new�������࣬����൱���Ǽ�ӵس��������Ǹ�������� ����͸�jdk�ӿ�����һ�������϶�̬������ص㣬������ò�������new������cglibnew�ģ�ֻ��Ҫ���Ǵ�������У�
		//������д�˸�������еķ���
		//���Ǹı������ĳЩ���ԣ��ǿ��Լ�ӵĲ�����������Եġ�
		proxy.invokeSuper(obj, arg2);//��Ҫ���ø���ķ�����invoke���������ģ��������ѭ��
		//��Ϊ���objʹ������������ã�������������е�����������ã��ͻ��intercept��
		//�����൱��findLove()�����е���findLove��������.����super���ǵ��������Լ�д�Ĵ��룬����������ľʹ������´��룬���������ǵĴ��룬
		System.out.println("------------");
		System.out.println("������ʵĻ�����׼������");
		return null;
	}
  
}
