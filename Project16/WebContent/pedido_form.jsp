<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedido Form</title>
</head>
<body>
	<form action="PedidoController1">
		<label>Fecha:</label><br>
		<input type = "text" name= "fecha" value = "${pedido.fecha}" /><br>
		
		<label>Cliente:</label><br>
		<input type = "text" name= "cliente" value = "${pedido.cliente}" /><br>
		
		<label>Observacion:</label><br>
		<input type = "text" name= "observacion" value = "${pedido.observacion}" /><br>
		
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>