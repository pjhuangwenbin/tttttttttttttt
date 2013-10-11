package com.test.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.model.Emp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Dao empdao=new EmpDao();
//		DaoProxy dp1=new DaoProxy(empdao);
//		Dao empProxy=dp1.getProxyInstance();
//		empProxy.insert();
//		Dao deptdao=new DeptDao();
//		
//		dp1.SetProxy(deptdao);
//		Dao deptProxy=dp1.getProxyInstance();
//		deptProxy.insert();
		
		BeanFactory f = new ClassPathXmlApplicationContext("applicationContext.xml");

		Dao empDao= (Dao)f.getBean("empDaoProxy");
		     Emp emp=new Emp();   
		empDao.delete(emp);
		empDao.insert(emp);

		
		
	
	}

}
