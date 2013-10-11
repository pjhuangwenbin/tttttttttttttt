package com.test.service;

import java.util.List;

import com.test.dao.EmpDao;
import com.test.model.Emp;

public class EmpService {

	private static final int PAGESIZE = 3;
	EmpDao empDao = new EmpDao();
	

	public List<Emp> selectAll(Emp e,int pageNo){
		return empDao.select();
	}
//	public int getPageCount(Emp e){
//		return empDao.getCount(e)%PAGESIZE==0?empDao.getCount(e)/PAGESIZE:empDao.getCount(e)/PAGESIZE+1;
//		
//	}
	
//	public Emp selectEmpByEmpno(int empno) {
//		return empDao.selectEmpByEmpno(empno);
//	}
	/**
	 * 
	 * @param emp
	 * @return flag =0 failure  flag =1 success flag =2 exist
	 */
	public int addEmp(Emp emp) {
		int flag =empDao.insert(emp) ;
		
		return flag ;
	}
	
	public Emp selectEmpByEmpno(int empno){
		return empDao.selectByEmpno(empno);
		
	}
	
	public int update(Emp emp){
		return empDao.update(emp);
	}
	public int delete(Emp emp){
		return empDao.delete(emp);
	}
	
}
