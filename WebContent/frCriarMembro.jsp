<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Criar Membro</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="template/css/bootstrap-theme.css">
<link rel="stylesheet" href="template/css/bootstrap.css">
<link rel="stylesheet" href="template/css/menu.css">

<!-- JavaScript -->
<script src="template/js/bootstrap.js"></script>

</head>
<body>
	<div class="container">
		<form action="CMembro" method="post" class="well span8">
			<div class="row">
				<div class="span3">
					<h4>Registro</h4>
				</div>

				<div class="span5">
					<label for="inputNome" class="col-sm-2 control-label">E-mail de Usu�rio</label>
					<input type="hidden" name="idGrupo" value="<%=request.getParameter("idGrupo")%>" />
					<div class="col-sm-12">
						<input type="text" class="form-control" name="e-mail"
							placeholder="Nome">
					</div>
				<br>
				<button type="submit" class="btn btn-primary pull-right"
					type="submit">Criar</button>
				<button type="reset" class="btn btn-default pull-right"
					type="submit">Limpar</button>
				<button type="button" class="btn btn-danger pull-right"
					onClick="history.go(-1)">Cancelar</button>
			</div>
		</form>
	</div>
</body>
</html>