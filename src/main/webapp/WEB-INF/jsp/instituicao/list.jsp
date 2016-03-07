<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="../favicon.png">
<title>Lista de Instituic�o</title>
</head>
<body>

	<h1> Lista de Institui��es </h1>
	
	<ul>
		<c:forEach items="${instituicaoList}" var="instituicao">
			<li>${instituicao.id } - ${instituicao.sigla } - ${instituicao.nome}</li>
		</c:forEach>
	</ul>
	
	<a href="add">Novo Instituicao</a>
	

</body>
</html>