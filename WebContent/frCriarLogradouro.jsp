<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
    <%@include file="template/css/bootstrap.min.css" %>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="template/js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
		<form role="form"  action ="CLogradouro" method="post">
			<div class="form-group">
				<label for="exampleInputPassword1">cep</label> 
				<input
					type="text" class="form-control" name="cep" id="cep"
					placeholder="CEP" required>
					
				<a href="#" id="callService" class="btn btn-primary"> Preencher Campos</a>
			</div>
			
			<div class="form-group">
				<label for="exampleInputPassword1">UF</label> <input
					type="text" class="form-control" name="uf" id="uf"
					placeholder="UF" required >
			</div>
			
			<div class="form-group">
				<label for="exampleInputPassword1">Cidade</label> <input
					type="text" class="form-control" name="cidade" id="cidade"
					placeholder="Cidade" required >
			</div>
			
			<div class="form-group">
				<label for="exampleInputPassword1">Distrito</label> <input
					type="text" class="form-control" name="distrito" id="distrito"
					placeholder="Distrito" required >
			</div>
			
			<div class="form-group">
				<label for="exampleInputPassword1">Endereço</label> <input
					type="text" class="form-control" name="endereco" id="endereco"
					placeholder="Endereço" required >
			</div>
			
			<div class="form-group">
				<label for="exampleInputPassword1">Numero</label> <input
					type="text" class="form-control" name="numero" id="numero"
					placeholder="Numero" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	
	
	
	<script> 		
		
		$(function() {
		    $('#callService').click(function() {
		    	
		    	var cep = $('#cep').val();
		        $.ajax({
		            type: 'GET',
		            url: 'https://viacep.com.br/ws/'+cep+'/json/',
		            dataType: 'json',
		            contentType: 'application/json; charset=utf-8',
		            success: function(response) {
		            		
		                	$('#cidade').val(response.localidade);
		                	$('#uf').val(response.uf);
		                	$('#distrito').val(response.bairro);
		                	$('#endereco').val(response.logradouro);
		                	

		            },
		            error: function(error) {
		                console.log(error);
		            }
		        });
		    });
		});
</script>
</body>
</html>