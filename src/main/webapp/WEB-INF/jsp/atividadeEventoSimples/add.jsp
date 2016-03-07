<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="/eventos/bootstrap/css/bootstrap.min.css" />

<title>Novo: Atividade Evento</title>

<style type="text/css">
	
	#evento_nome{
		
	}
	
</style>

</head>
<body>
	
	<div class="container-fluid">
		
		<form id="frm_evento" action="${linkTo[AtividadeEventoSimplesController].save}" role="form">
		
		<div class="form-group">
		
			<label>Evento:</label>
			
			<select name="atividadeEvento.evento.id" class="form-control">
				
				<c:forEach items="${eventos}" var="evento">
					<option value="${evento.id}">${evento.nome }</option>
				</c:forEach>
				
			</select>
			
			<label>Tipo:</label>
			<select name="atividadeEvento.tipoAtividadeEvento.id" class="form-control">
				<c:forEach items="${tipos}" var="tipo">
					<option value="${tipo.id}">${tipo.nome}</option>
				</c:forEach>
			</select>
			
		</div>
		
		<div class="form-group">
		
			<label>Nome da Atividade:</label>
	
			<input type="text" name="atividadeEvento.nome" placeholder="Descrição da Atividade" class="form-control" />
			
		</div>
		
		<div class="form-group">
			
			<label> Horário: </label>
			<div class="input-group">
      			<div class="input-group-addon">Data/Hora:</div>
			
				<input type="datetime-local" name="horario" placeholder="dd/mm/aaaa hh:mm" class="form-control data" />
				
			</div>
			
			
		</div>
		
		<input type="submit" value="Salvar Evento" class="btn btn-primary"/>
		<a href="${linkTo[AtividadeEventoSimplesController].list}" class="btn btn-info">Listar Atividades </a>
	
	</form>
	
	</div>

</body>
</html>