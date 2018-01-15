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

<%@page language="java" import="modelo.Usuario"%>
<%@page language="java" import="java.util.ArrayList"%>


</head>
<body>
	<% Usuario motorista = (Usuario) request.getAttribute("motorista");%>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Grupos</h3>
			</div>
			<ul class="list-group">
				<li class="list-group-item">
					<div class="row toggle" id="dropdown-detail-1"
						data-toggle="detail-1">
						<div class="col-xs-10">Lista</div>
						<div class="col-xs-2">
							<i class="fa fa-chevron-down pull-right"></i>
						</div>
					</div>
					<div class="col-xs-1">
									Id
								</div>
								<div class="col-xs-4">
									Nome
								</div>
								<div class="col-xs-4">
									E-mail
								</div>
								<div class="col-xs-3">
									Telefone
								</div>
					<div id="detail-1">
						<hr></hr>
						<div class="container">
							<div class="fluid-row">
								<div class="col-xs-1">
									<%=motorista.getId()%>
								</div>
								<div class="col-xs-4">
									<%=motorista.getNome()%>
								</div>
								<div class="col-xs-4">
									<%=motorista.getEmail()%>
								</div>
								<div class="col-xs-3">
									<%=motorista.getTelefone()%>
								</div>
								<br>
								<div class="col-xs-11">
							<button type="button" class="btn btn-danger pull-right"
								onClick="history.go(-1)">Voltar</button>
								</div>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>