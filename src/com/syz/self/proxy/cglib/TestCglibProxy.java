package com.syz.self.proxy.cglib;

import com.gupaoedu.vip.proxy.cglib.GPMeipo;
import com.gupaoedu.vip.proxy.cglib.YunZhongYu;

public class TestCglibProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//jdk�Ķ�̬������ͨ���ӿ�������ǿ��ת����
		//�����Ժ�Ĵ�����󣬿���ǿ��ת��Ϊ�ӿ�
		
		
		//CGLIB�Ķ�̬������ͨ������һ���������������࣬Ȼ����д����ķ�����Ĭ�ϻ���д���и���ķ�����
		//�����Ժ�Ķ��󣬿���ǿ��ת��Ϊ��������󣬣�Ҳ�������Լ�д���ࣩ
		//�������ø�ֵ������
		
		
		try {
			//jdk�н����ñ���������������cglib������ò�������new������cglibnew�ģ�ֻ��Ҫ���Ǵ��������
			YunZhongYu obj = (YunZhongYu)new GPMeipo().getInstance(YunZhongYu.class);
			obj.findLove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
