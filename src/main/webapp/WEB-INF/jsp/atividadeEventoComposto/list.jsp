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
		
		<a href="${linkTo[AtividadeEventoSimplesController].add}" class="btn btn-success">Novo</a>
	
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Tipo</th>
					<th>Responsáveis</th>
					<th>Horário</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${atividadeEventoList}" var="ae">
					<tr>
						<td>${ae.id}</td>
						<td> ${ae.nome}</td>
						<td> ${ae.tipoAtividadeEvento.nome}</td>
						<td> - </td>
						<td> <f:formatDate value="${ae.horario.time}" pattern="dd/MM/yyyy hh:mm" /> </td>
					</tr>
				</c:forEach>
				<c:if test="${atividadeEventoList.size() == 0 || atividadeEventoList == null}">
					<tr>
						<td colspan="6">Nenhuma Atividade disponível</td>
					</tr>
				</c:if>
			</tbody>
		
		</table>
	
	</div>
	
</body>
</html>