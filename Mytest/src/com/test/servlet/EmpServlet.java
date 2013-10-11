package com.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.test.dao.EmpDao;

import com.test.model.Emp;
import com.test.service.EmpService;
import com.test.util.Constant;
import com.test.util.MyEmpPage;


@WebServlet("/servlet/EmpServlet")
public class EmpServlet  extends BaseServlet  {
	
	Logger log = Logger.getLogger(EmpServlet.class);
	EmpService empService = new EmpService();
	
    public void doBusiness(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	String flag = request.getParameter("flag");
    	log.info(flag);
    	if("select".equals(flag)){
    		select(request,response);
    	}else if("delete".equals(flag)){
    		delete(request,response);
    	}else if("toupdate".equals(flag)){
    		toUpdate(request,response);
    	}else if("doupdate".equals(flag)){
    		doUpdate(request,response);
    	}else if("add".equals(flag)){
    		add(request,response);
    	}
    	
    }
    
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int empno =new Integer(request.getParameter("empno"));
    	String ename= request.getParameter("ename");
    	int sal =new Integer(request.getParameter("sal"));
    	int deptno =new Integer(request.getParameter("deptno"));
    	Emp emp = new Emp(empno,ename,sal,deptno);
    	int flag = empService.addEmp(emp);
		if(flag==1){
			select(request,response);
		}else if(flag==2){
			request.setAttribute("info", "empno is exist ");
			request.getRequestDispatcher(Constant.FAILURE).forward(request, response);
		}else{
			request.setAttribute("info", "delete failure");
			request.getRequestDispatcher(Constant.FAILURE).forward(request, response);
		}
    }
    
    public void toUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int empno =new Integer(request.getParameter("empno"));
    	Emp emp = empService.selectEmpByEmpno(empno);
    	request.setAttribute("emp", emp);
    	request.getRequestDispatcher(Constant.EMP_EDIT).forward(request, response);

    }
    
    public void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int empno =new Integer(request.getParameter("empno"));
    	String ename= request.getParameter("ename");
    	int sal =new Integer(request.getParameter("sal"));
    	int deptno =new Integer(request.getParameter("deptno"));
    	Emp emp = new Emp(empno,ename,sal,deptno);
    	int flag = empService.update(emp);
    	if(flag==1){
    		select(request,response);
		}else{
			request.setAttribute("info", "update failure");
			request.getRequestDispatcher(Constant.FAILURE).forward(request, response);
		}
    }
    
    public void select(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Emp> allEmps ;
    	Emp e=new Emp();
    	int pageNo;
    	if(request.getParameter("ename")==null&&"".equals(request.getParameter("ename"))){   		
    		e.setEname(null);
    	}
    	else{
    		e.setEname(request.getParameter("ename"));   		
    	}
    	if(request.getParameter("pageNo")==null){
    		pageNo=1;
    	}else{
    		pageNo=Integer.parseInt(request.getParameter("pageNo"));
    	}
    	allEmps = new EmpDao().select();
    	MyEmpPage ePage=new MyEmpPage();
    	ePage.setEname(e.getEname());
    	ePage.setPageNo(pageNo);
    	
    	request.setAttribute("ePage",ePage);
    	request.setAttribute("allEmps", allEmps);
    	request.getRequestDispatcher(Constant.EMP_INDEX).forward(request, response);
    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int empno =new Integer(request.getParameter("empno"));
    	Emp emp=empService.selectEmpByEmpno(empno);
		int result = empService.delete(emp);
		if(result==1){
			select(request,response);
		}else{
			request.setAttribute("info", "delete failure");
			request.getRequestDispatcher(Constant.FAILURE).forward(request, response);
		}
    }
    
}
