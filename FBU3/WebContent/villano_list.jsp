<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Villano list</title>
</head>
<body>
<table border="1">
		<tr>
			<th>
			  <form action="VillanoController">
			  		<input type="submit" name="btn_new"
			  		value="New "/>
			  </form>
			  <a href="VillanoReport">Print report</a>
			</th>
			<td>IdVillano</td>
			<td>colorBigote</td>
			<td>colorSombrero</td>
			<td>aspecto</td>
		
			
		</tr>
		 <c:forEach var="villano" items="${villanos}">
		 	 <tr>
		 	 	<td>
		 	 		<form action="VillanoController">
		 	 			<input type="hidden" name="id" value="${villano.id}">
		 	 			<input type="submit" name="btn_edit" value="Edit"/>
		 	 			 <input type="submit" name="btn_delete" value="Delete"/>
		 	 		</form>
		 	 	</td>
		 	 	<td>${villano.id}</td>
		 	 	<td>${villano.colorBigote}</td>
		 	 	<td>${villano.colorSombrero}</td>
		 	 	<td>${villano.aspecto}</td>
		 	 	
		 	 </tr>	
		 </c:forEach>
	</table>

</body>
</html>