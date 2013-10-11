package com.test.dao;

import com.test.model.Emp;

public class TestHibernate2 {

	private static EmpDao empdao;

	public static void main(String[] args) {
		empdao = null;
		Emp emp =new Emp();


		emp.setEmpno(886);
		emp.setEname("lisi");
		emp.setSal(633);
		emp.setDeptno(10);
		empdao.insert(emp);

	}

}
