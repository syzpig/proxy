package com.fuzilei.test.yincanghefugai;

public class Test {
	public static void main(String[] args) {
		Shape shape = new Circle();
		System.out.println(shape.name);
		shape.printType();
		shape.printName();
		
		//�ܽ᣺
		//����ֻ��ԷǾ�̬��������̬�������ܱ��̳У����Ծʹ��ڸ���һ˵�ˣ�������������Գ�Ա�����;�̬�����ġ�
		//��2��֮��������ǣ�������RTTI��Runtime type  identification��Լ���ģ�������ȴ���ܸ�Լ����
		//Ҳ����˵ֻ�и��Ƿ����Ż���ж�̬�󶨣��������ǲ��ᷢ����̬�󶨵ġ�
		//��Java�У�����static������final�������������еķ������Ƕ�̬�󶨡���ˣ��ͻ���������������
	}
}
