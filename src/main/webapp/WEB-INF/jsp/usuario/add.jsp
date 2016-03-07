<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="/eventos/bootstrap/css/bootstrap.min.css" />

<title>Sign Up</title>

</head>
<body>
	
	<div class="container-fluid">
		
		<form id="frm_evento" action="${linkTo[UsuarioController].save}" role="form">
		
		<div class="form-group">
		
			<div class="form-group">
		
				<label>Login:</label>
		
				<input type="text" name="usuario.login" placeholder="login/username.." class="form-control" />
				
				<label>Senha:</label>
		
				<input type="password" name="usuario.senha" placeholder="senha/password.." class="form-control" />
			
			</div>
		
			<label>Perfil:</label>
			
			<select name="usuario.perfilUsuario.id" class="form-control">
				
				<c:forEach items="${perfis}" var="perfil">
					<option value="${perfil.id}">${perfil.nome }</option>
				</c:forEach>
				
			</select>
			
			<label>Segmento:</label>
			<select name="usuario.segmentoUsuario.id" class="form-control">
				<c:forEach items="${segmentos}" var="seg">
					<option value="${seg.id}">${seg.nome}</option>
				</c:forEach>
			</select>
			
		</div>
		
		<input type="submit" value="Salvar" class="btn btn-primary"/>
		<a href="${linkTo[UsuarioController].list}" class="btn btn-info">Listar Usuario </a>
	
	</form>
	
	</div>

</body>
</html>