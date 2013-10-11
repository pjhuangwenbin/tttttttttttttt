package com.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet  {

	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	request.setCharacterEncoding("utf-8");
	    	response.setCharacterEncoding("utf-8");
	    	doBusiness(request,response);
	 }
	
	 
	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	request.setCharacterEncoding("utf-8");
	    	response.setCharacterEncoding("utf-8");
	    	doBusiness(request,response);
	    }
	    
	    public abstract void doBusiness(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
	    
	    public void redirect(HttpServletRequest request, HttpServletResponse response,String url) throws ServletException, IOException {
	    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	    	response.sendRedirect(basePath+url);
	    }

}
