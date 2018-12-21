package com.syz.self.proxy.custom.test1;

import java.lang.reflect.Method;

//手写一个代理实现接口
public interface SyzInvocationHandler {
	 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
