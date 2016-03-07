<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="jquery-1.9.0.min.js"></script>

<script type="text/javascript">
	
	$(document).ready(function(){
		
			
			
			//Chanando URL sem parametros..
			$("#link_eventos").click(function(){
				
				var url = "http://localhost:8181/eventos/evento/listJSON";
			
				$.get(url, function(data){
					var eventos = '';
					for (var i = 0; i < data.list.length; i++) {
						var array_element = data.list[i];
						//eventos += data.list[i].id + ' - ' + data.list[i].nome + '\n';
						var evento = data.list[i];
						addEventoLI(evento);
						
					}
					
				});
				
			});
			
			//Buscar um evento por ID
			$('#link_evento').click(function(){
				
				//URL com parametros..
				var url = "http://localhost:8181/eventos/evento/showJSON";
				var parametros = {id: $('#evento_id').val()};
				
				$.get(url, parametros, function(data){
					
					//alert(data.evento.id + ' - ' +data.evento.nome + ' - ' + data.evento.dataInicio);
					//$('#div_eventos').text(data.evento.nome);
					addEventoLI(data.evento);
					
				});
				
				
			});
			
			////Buscar um evento por ID, Analisando o sucesso da resposta
			$('#link_evento2').click(function(){
				
				//URL com parametros..
				var url = "http://localhost:8181/eventos/evento/showJSON";
				var parametros = {id:15}
				
				var $xhr = $.get(url, parametros);
				
				$xhr.done(function(data){
					
					alert('Done: \n'+data.evento.id + ' - ' +data.evento.nome + ' - ' + data.evento.dataInicio);
									
					//$('#div_eventos').text(data.evento.nome);
					//$('#div_eventos').append(data.evento.nome);
					addEventoLI(data.evento);
									
					
				});
				
				$xhr.fail(function(data){
					
					alert('Fail: \n'+data.responseText);
					
				});
				
				
			});
			
			$('#link_apagar_list').click(function(){
				$('#eventos').text('');	
			});
			
			
			function addEventoLI(evento){
				$('#eventos').append("<li>" + evento.nome + "</li");
			};
			
		
		
	});
	
</script>

</head>
<body>

	<h1>Oi..</h1>
	
	<a id="link_eventos" href="#eventos_todos">Exibir todos Eventos Ajax Simples</a> <br>
	<a id="link_evento" href="#evento">Exibir um evento</a> <input id="evento_id" type="text" placeholder="digite o ID" /> <br>
	<a id="link_evento2" href="#evento2">Exibir um evento(Analisando a resposta)</a> <br>
	<a id="link_apagar_list" href="#apagar">Limpar Lista</a>
	
	<h3>Eventos:</h3>
	<div id="div_eventos" style="color: blue;">
		<ul id="eventos"></ul>
	</div>

</body>
</html>