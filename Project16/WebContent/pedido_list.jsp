<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedido</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="PedidoController1">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Fecha</th>
			 <th>Cliente</th>
			 <th>Observacion</th>
			
		</tr>
		<c:forEach var="pedido" items="${pedidos}">
		
		<tr>
			<td>
				<form action= "PedidoController1">
					<input type = "hidden" name = "id" value= "${pedido.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${pedido.id}</td>
			<td> ${pedido.fecha}</td>
			<td> ${pedido.cliente}</td>
			<td> ${pedido.observacion}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="PedidoReport">
				
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>