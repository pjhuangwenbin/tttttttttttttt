package com.test.util;


import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBUtil {
	
	
	
	private static  SessionFactory factory;
	static{
		Configuration cfg = new Configuration();
		
		cfg.configure("/hibernate.cfg.xml");
		 factory = cfg.buildSessionFactory();
		
	}

	//单例
	public DBUtil(){		
	}
	
	

	//Session是org.hibernate包中的,当然也可以是org.hibernate.classic包中的Session,不过不建议导入后面,这个包中的session已经淘汰了.
	public static  Session getSession(){
		
		return factory.openSession();
	}
	
	public static void add(Object obj)
	{
		Session session = DBUtil.getSession();
		Transaction tran = session.beginTransaction();
		try{
		session.save(obj);
		tran.commit();
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			session.close();
		}
	}
	
	public static void delete(Object obj)
	{
		Session session = DBUtil.getSession();
		Transaction tran = session.beginTransaction();
		try{
		session.delete(obj);
		tran.commit();
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			session.close();
		}
	}
	public static void update(Object obj)
	{
		Session session = DBUtil.getSession();
		Transaction tran = session.beginTransaction();
		try{
		session.update(obj);
		tran.commit();
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			session.close();
		}
	}
	
	public static Object get(Class c ,Serializable s)
	{
		Session session = DBUtil.getSession();
		Object obj = null; 
		try{
		obj = session.get(c, s);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return obj;
	}
}
