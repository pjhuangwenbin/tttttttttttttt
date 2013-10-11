package com.test.dao;

import java.util.List;





import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.test.model.Emp;
import com.test.util.DBUtil;

public class TestHibernate {


	public static void main(String[] args) {
		add();
	}
	
	public static void add(){
		   
		    Emp oc = new Emp();
		    oc.setEmpno(10086);
		    oc.setEname("huang");
		    oc.setSal(500);	
		    oc.setEmpno(10);
		    DBUtil.add(oc);		    
		   	    
		
	}
}
