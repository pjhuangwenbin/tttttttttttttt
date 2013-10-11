package com.test.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.model.Emp;
import com.test.util.DBUtil;

public class EmpDao implements Dao {
	private static DBUtil db = new DBUtil();
	private static Session session = db.getSession();
	private static Transaction tran = session.beginTransaction();

	@Override
	public int insert(Object o) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			Emp emp = (Emp) o;
			session.save(emp);
			System.out.println("insert EmpDao");
			tran.commit();
			flag = 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;

	}

	@Override
	public int delete(Object o) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			Emp emp = (Emp) o;
			session.delete(emp);
			System.out.println("delete EmpDao");
			tran.commit();
			flag = 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;

	}

	@Override
	public int update(Object o) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			Emp emp = (Emp) o;
			session.update(emp);

			System.out.println("update EmpDao");
			tran.commit();
			flag = 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;

	}

	public List<Emp> select() {
		// TODO Auto-generated method stub
		String sql = "select e from Emp e";
		Query query = session.createQuery(sql);
		List<Emp> empall = query.list();
		tran.commit();
		return empall;

	}

	public Emp selectByEmpno(int empno) {

		Emp emp = null;
		try {
			String sql = "select e from Emp e where e.empno=" + empno + "";
			Query query = session.createQuery(sql);
			List<Emp> temp = query.list();
			emp = (Emp) temp;

		} catch (Exception e) {
			System.out.println(e);
		}

		return emp;
	}

}