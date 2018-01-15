<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<!-- CSS -->
<link rel="stylesheet" href="template/css/bootstrap-theme.css">
<link rel="stylesheet" href="template/css/bootstrap.css">
<link rel="stylesheet" href="template/css/menu.css">

<!-- JavaScript -->
<script src="template/js/bootstrap.js"></script>
<script src="template/jquery.js"></script>
</head>
<body>
	<script>
		$(function() {
			$('#callService').click(function() {
				var cep = $('#cep').val();
				$.ajax({
					type : 'GET',
					url : 'https://viacep.com.br/ws/' + cep + '/json/',
					dataType : 'json',
					contentType : 'application/json; charset=utf-8',
					success : function(response) {
						$('#cidade').val(response.localidade);
						$('#uf').val(response.uf);
						$('#distrito').val(response.bairro);
						$('#endereco').val(response.logradouro);
					},
					error : function(error) {
						console.log(error);
					}
				});
			});
		});
	</script>
</body>
</html>