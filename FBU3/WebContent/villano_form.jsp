<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Villano Form</title>
</head>
<body>

	<form action="VillanoController">
		<label>colorBigote:</label><br />
		<input type="text" name="colorbigote" value="${villano.colorBigote}" /><br />
		
		<label>colorSombrero:</label><br />
		<input type="text" name="colorsombrero" value="${villano.colorSombrero}" /><br />
		
		<label>aspecto:</label><br />
		<input type="text" name="aspecto" value="${villano.aspecto}" /><br />
	
		<input type="submit" name="btn_save" value="Save" />	
	</form>


</body>
</html>