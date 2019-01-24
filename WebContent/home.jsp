<%@page import="com.Bean.StudentBean"%>
<%@page import="com.Dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<StudentBean> list = StudentDao.getAllStudent();
%>

<table border="1" width="100%" cellpadding=5 cellspacing=5>
	<tr>
		<th>ID</th>
		<th>FNAME</th>
		<th>LNAME</th>
		<th>EMAIL</th>
		<th>CONTACT</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>
	<%
		for(StudentBean s : list)
		{
	%>
	<tr>
		<td><%=s.getId() %></td>
		<td><%=s.getFname() %></td>
		<td><%=s.getLname() %></td>
		<td><%=s.getEmail() %></td>
		<td><%=s.getContact() %></td>
		
		
		<td>
		<form name = "editform" method ="post" action="ActionController" >
		<input type ="hidden" name = "id" value = "<%= s.getId()%>">
		<input type ="submit" name ="action" value = "EDIT">
		
		</form>
	</td>
	
		
	<td>
		<form name = "deleteform" method ="post" action="ActionController" >
		
		<input type ="hidden" name = "id" value = "<%= s.getId()%>">
		<input type ="submit" name ="action" value = "DELETE">
		
		
		</form>
	</td>
	</tr>
	
	
	
	<%		
		}
	%>
</table>


</body>
</html>