package com.test.action;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.WebApplicationContext;




import com.opensymphony.xwork2.ActionContext;
import com.test.model.Emp;
import com.test.service.EmpService;
import com.test.util.Constant;



public class EmpAction {
	Emp emp;
	int empno;
	
	
	
	public EmpAction(){
		System.out.println("EmpAction");
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	//= (EmpService)Constant.factory.getBean("empService")
	EmpService empService ;
	
	public EmpService getEmpService() {
		return empService;
	}
	public void setEmpService(EmpService empService) {
		System.out.println("test spring ioc");
		this.empService = empService;
	}
	public void toAdd()  {
		//to do
	}
	
	
	
	public int delete()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		int flag=empService.delete(emp);
		if(flag==1){
			return flag;
		}else{	
			request.setAttribute("info", "delete failure");
			return flag;
		}
	}	
	
	
	
 
	public int update(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int flag=empService.update(emp);
		if(flag==1){
			return flag;
		}else{
			request.setAttribute("info", "update failure");
			return flag;
		}
		
	}
  
	public int add(){
	   //取得application
	   
	   // ActionContext act=ActionContext.getContext();
	   // HttpServletRequest request = (HttpServletRequest) act.get(ServletActionContext.HTTP_REQUEST);
	      HttpServletRequest request = ServletActionContext.getRequest();
	   // ServletContext application=request.getSession().getServletContext();
	   // BeanFactory factory = (BeanFactory)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		int flag = empService.addEmp(emp);
		
	   	if (flag == 1){
	   		return flag;
		} else {
			request.setAttribute("info", "add failure");
			return flag;
		}
	
	}			
	
}
