package com.fuzilei.test;
//����
public class Dervied extends Base {
	private String name = "dervied";
	 
    public Dervied() {
        tellName();
        printName();
    }
 
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }
 
    public void printName() {
        System.out.println("Dervied print name: " + name);
    }
 
    public static void main(String[] args){
    	//�����Ǵ���֮ʱ��Ĭ�ϴ���һ��super()�����๹�췽�����棬�������ʾ����д�ڵ�һ�У�Ҳ���ᱨ��
    	//���ǲ��ɽ�������ڵ�һ��֮������У�������������ֱ�ӱ������������⣬������ô�룬
    	//���봴��һ�����࣬����ĸ�����аɣ�������඼û�У�����ô����������ࣿ�Ͼ�������������ݸ������ġ�
    	
    	//��̳�ʱ�������ĵ���˳��ͳ�ʼ��˳��Ҫ��סһ�㣺����Ĺ����������Լ���ʼ������һ���������ǰ��
        new Dervied();
        
        //https://blog.csdn.net/qq_32409957/article/details/80927138
    }


}
