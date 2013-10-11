<%@ page language="java"  import="com.test.dao.*,com.test.model.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    
    <%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+ "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=basePath%>servlet/EmpServlet?flag=doupdate" method="post">


<p>emp info:</p>
<p>empno:
  <input name="empno" type="text" id="empno" value="${emp.empno }" readonly size="20" />
  <Br />
  ename:
  <input name="ename" type="text"  value="${emp.ename }" size="20" />
  <Br />
  sal:
  <input name="sal" type="text"  value="${emp.sal }" size="20" />
  <Br />
  deptno:
  <select name="deptno" size="1"> 
	<option value="10" <c:if test="${emp.deptno==10}">selected</c:if> >ISO</option>
    <option value="20"<c:if test="${emp.deptno==20}">selected</c:if> >admin</option>
    <option value="30" <c:if test="${emp.deptno==30}">selected</c:if> >sale</option>
    <option value="40" <c:if test="${emp.deptno==40}">selected</c:if> >market</option>
    <option value="50" <c:if test="${emp.deptno==50}">selected</c:if> >infra</option>
  </select>
  </p>
</p>

<p>
  <label>
    <input type="submit" name="Submit" value="submit" />
  </label>
  <label>
  <input type="reset" name="Submit2" value="reset" />
  </label>
  
  </form>
</p>
</body>
</html>
