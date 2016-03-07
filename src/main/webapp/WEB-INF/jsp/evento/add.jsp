<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="/eventos/bootstrap/css/bootstrap.min.css" />

<title>Novo Evento</title>

<style type="text/css">
	
	#evento_nome{
		
	}
	
</style>

</head>
<body>
	
	<div class="container-fluid">
		
		<form id="frm_evento" action="save" role="form">
		
		<div class="form-group">
		
			<label>Nome do Evento:</label>
	
			<input id="evento_nome" type="text" name="evento.nome" placeholder="Nome do Evento" class="form-control" />
			
		</div>
		
		<div class="form-group">
			
			<label for="evento.dataInicio">Período: </label>
			<div class="input-group">
      			<div class="input-group-addon">De:</div>
			
				<input type="text" name="evento.dataInicio" placeholder="dd/mm/aaaa" class="form-control data" />
				
      			<div class="input-group-addon">Até:</div>
			
				<input type="text" name="evento.dataFim" placeholder="dd/mm/aaaa" class="form-control data"/>
				
			</div>
			
			
		</div>
		
		<div class="form-group">
		
			<label>Tipo Evento:</label>
			
			<select name="evento.tipoEvento.id" class="form-control">
				
				<c:forEach items="${tipos}" var="tipo">
					<option value="${tipo.id}">${tipo.nome}</option>
				</c:forEach>
				
			</select>
			
			<label>Instituição:</label>
			<select name="evento.instituicao.id" class="form-control">
				<c:forEach items="${instituicoes}" var="inst">
					<option value="${inst.id}">${inst.sigla} - ${inst.nome }</option>
				</c:forEach>
			</select>
			
		</div>
		
		<input type="submit" value="Salvar Evento" class="btn btn-primary"/>
		<a href="list" class="btn btn-info">Listar Eventos </a>
	
	</form>
		
	
	</div>
		

</body>
</html>