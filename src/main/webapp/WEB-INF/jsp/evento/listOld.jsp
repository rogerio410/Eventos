<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Projeto Eventos</title>
</head>
<body>

	<ul>
		<c:forEach items="${eventoList}" var="evento">
			<li>${evento.id} - ${evento.nome}</li>
		</c:forEach>
	</ul>
	
	<a href="add">Novo Evento</a>
	
	
</body>
</html>