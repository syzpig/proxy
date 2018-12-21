package com.syz.self.proxy.jdk.test2;

public class TestLove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Persion p=(Persion)new MeiPo().getIntersince(new GuanYu());
        System.out.println(p.getClass());
        p.findLove();
	}

}
