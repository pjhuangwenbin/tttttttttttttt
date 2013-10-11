package com.test.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DaoProxy {

	Dao dao;
	public DaoProxy(){
		
	}
	public DaoProxy(Dao dao){
		this.dao=dao;
	}
	public Dao GetProxy(Dao dao){
		return dao;
	}
	public void SetProxy(Dao dao){
		this.dao=dao;
	}
	public Dao getProxyInstance(){
		InvocationHandler ih=new TranscationInvocationHandler(dao);
		Dao proxy=(Dao)Proxy.newProxyInstance(EmpDao.class.getClassLoader(), EmpDao.class.getInterfaces(), ih);
		return proxy;
	}
	

}
