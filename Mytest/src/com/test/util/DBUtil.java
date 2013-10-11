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

	//����
	public DBUtil(){		
	}
	
	

	//Session��org.hibernate���е�,��ȻҲ������org.hibernate.classic���е�Session,���������鵼�����,������е�session�Ѿ���̭��.
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
