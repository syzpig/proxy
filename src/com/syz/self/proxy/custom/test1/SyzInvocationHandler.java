package com.syz.self.proxy.custom.test1;

import java.lang.reflect.Method;

//��дһ������ʵ�ֽӿ�
public interface SyzInvocationHandler {
	 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
