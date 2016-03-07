<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<link rel="stylesheet" href="/eventos/bootstrap/css/bootstrap.min.css" />
<title>Projeto Eventos</title>
</head>
<body>

	<div class="container-fluid">
		
		<a href="add" class="btn btn-success">Novo Evento</a>
	
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Fase</th>
					<th>Nome Evento</th>
					<th>Instituição</th>
					<th>Início</th>
					<th>Término</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${eventoList}" var="evento">
					<tr>
						<td>${evento.id}</td>
						<td> ${evento.faseEvento.nome}</td>
						<td> ${evento.nome}</td>
						<td> ${evento.instituicao.nome}</td>
						<td> <f:formatDate value="${evento.dataInicio.time}" pattern="dd/MM/yyyy"/> </td>
						<td> <f:formatDate value="${evento.dataFim.time}" pattern="dd/MM/yyyy"/> </td>
					</tr>
				</c:forEach>
				<c:if test="${eventoList.size() == 0 }">
					<tr>
						<td colspan="6">Nenhum evento disponível</td>
					</tr>
				</c:if>
			</tbody>
		
		</table>

		
	
	</div>
	
	
</body>
</html>