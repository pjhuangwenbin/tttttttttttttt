<%@ page language="java" import="java.util.*,java.sql.*,com.test.dao.*,com.test.model.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+ "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript">

var operateFlag = "add" ;
var tempRow ;  //被更新的行
function addEmp(){
	  var row = document.getElementById("empTable").insertRow();
	  var cell= row.insertCell();
	  cell.innerHTML = document.getElementById("empno").value;
	  cell= row.insertCell();
	  cell.innerHTML = document.getElementById("ename").value;
	  cell= row.insertCell();
	  cell.innerHTML = document.getElementById("sal").value;
	  cell= row.insertCell();
	  cell.innerHTML = document.getElementById("deptno").value;
	  cell= row.insertCell();
	  cell.innerHTML ="<input type='submit' name='Submit2' value='delete' onclick='deleteEmp(this.parentNode.parentNode)' /> <input type='submit' name='Submit3' value='update' onclick='toUpdateEmp(this.parentNode.parentNode)' />";
	  document.getElementById("empForm").reset();
	  alert("add success !");
}

function deleteEmp(row){
	 
	
	var flag = window.confirm("你确定要delete吗");
	  if(flag==true){
		  location.href="<%=basePath%>servlet/EmpServlet?flag=delete&empno="+ row.cells[0].innerHTML ;
	  }
      
}

function toUpdateEmp(row){
	 location.href="<%=basePath%>servlet/EmpServlet?flag=toupdate&empno="+ row.cells[0].innerHTML ;
}


function addOrUpdateEmp(){
   if(operateFlag=="add"){
        addEmp();
   }else{
       updateEmp();
   }
}

function updateEmp(){
   tempRow.cells[0].innerHTML=document.getElementById("empno").value;
   tempRow.cells[1].innerHTML=document.getElementById("ename").value;
   tempRow.cells[2].innerHTML=document.getElementById("sal").value;
   tempRow.cells[3].innerHTML=document.getElementById("deptno").value;
   alert("update success");
   document.getElementById("empForm").reset();
   operateFlag = "add" ;
   document.getElementById("empno").readOnly=false;
}
</script>
</head>

<body>
<form action="servlet/EmpServlet?flag=select" method="post">
<p>按selectName查询:   
  <input type="text"  id="ename"  name="ename" value="${requestScope.ePage.ename}"/> 
  <input type="submit" name="Submit" value="查询" />
</p>
</form>
<p>雇员信息如下：</p>
<table  id="empTable" width="60%"  border="1">
  <tr align="left" >
    <th width="20%" height="35">empno</th>
    <th width="20%">ename</th>
    <th width="20%">sal</th>
    <th width="14%">deptno</th>
    <th width="26%">operate</th>
  </tr>
<c:forEach items="${requestScope.allEmps }" var="emp">
      <tr>
	    <td>${emp.empno }</td>
	    <td>${emp.ename}</td>
	    <td>${emp.sal} </td>
	    <td>${emp.deptno}</td>
	    <td>
	      <input type="submit" name="Submit2" value="delete"  onclick="deleteEmp(this.parentNode.parentNode)"/>
	      <input type="submit" name="Submit3" value="update" onclick="toUpdateEmp(this.parentNode.parentNode)" /></td>
	  </tr>
</c:forEach>
</table>
<p>&nbsp; </p>


</body>
</html>
