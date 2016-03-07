<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Evento</title>
</head>
<body>

	<form action="save">
	
		<input type="text" name="evento.nome" placeholder="Nome do Evento" />
		Data Inicio: <input type="text" name="evento.dataInicio" placeholder="dd/mm/aaaa" />
		Data Fim: <input type="text" name="evento.dataFim" placeholder="dd/mm/aaaa" />
		
		<br />
		Tipo Evento:
		<select name="evento.tipoEvento.id">
			
			<c:forEach items="${tipos}" var="tipo">
				<option value="${tipo.id}">${tipo.nome }</option>
			</c:forEach>
			
		</select>
		
		Instituição:
		<select name="evento.instituicao.id">
			<c:forEach items="${instituicoes}" var="inst">
				<option value="${inst.id}">${inst.sigla} - ${inst.nome }</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="Salvar Evento"/>
	
	</form>

</body>
</html>