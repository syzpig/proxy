package com.syz.self.proxy.jdk.test1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.gupaoedu.vip.proxy.jdk.Person;

import sun.misc.ProxyGenerator;

public class TestFindLove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    try {
	        //����
			Persion per=(Persion)new MeiPao().getInstance(new ZhangFei());
			System.out.println(per.getClass());
			per.findLove();
			
			//����jdk��ʽ��ȡ�ֽ��루�����ֽ��������Ķ���
		    byte[] data=ProxyGenerator.generateProxyClass("$syz0", new Class[]{Person.class});
			FileOutputStream out=new FileOutputStream("D:\\GuPaoPorxy\\$syz0.class");
			out.write(data);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
