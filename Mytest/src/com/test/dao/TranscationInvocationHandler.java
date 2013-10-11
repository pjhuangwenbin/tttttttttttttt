package com.test.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TranscationInvocationHandler implements InvocationHandler{

	Dao dao;
	public TranscationInvocationHandler(Dao dao){
		this.dao=dao;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("transaction begin");
		Object o=method.invoke(dao, args);
		System.out.println("transaction commit");
		return 0;
	}

}
