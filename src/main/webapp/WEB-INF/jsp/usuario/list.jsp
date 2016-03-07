<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<link rel="stylesheet" href="/eventos/bootstrap/css/bootstrap.min.css" />
<title>Usuários</title>
</head>
<body>

	<div class="container-fluid">
		
		<a href="${linkTo[UsuarioController].add}" class="btn btn-success">Novo</a>
	
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Login</th>
					<th>Segmento</th>
					<th>Perfil</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${usuarioList}" var="u">
					<tr>
						<td>${u.id}</td>
						<td> ${u.login}</td>
						<td> ${u.segmentoUsuario.nome}</td>
						<td> ${u.perfilUsuario.nome}</td>
					</tr>
				</c:forEach>
				<c:if test="${usuarioList.size() == 0 || usuarioList == null}">
					<tr>
						<td colspan="6">Vazio</td>
					</tr>
				</c:if>
			</tbody>
		
		</table>
	
	</div>
	
</body>
</html>