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

<%@page language="java" import="modelo.Carona"%>
<%@page language="java" import="java.util.ArrayList"%>
</head>
<body>
	<% ArrayList<Carona> lista = (ArrayList<Carona>) request.getAttribute("lista");%>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Caronas</h3>
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
					<div class="col-xs-1">Id</div>
					<div class="col-xs-2">Data</div>
					<div class="col-xs-2">Hora</div>
					<div class="col-xs-2">Id Origem</div>
					<div class="col-xs-1">Id destino</div>
					<div id="detail-1">
						<hr></hr>
						<div class="container">
							<div class="fluid-row">
								<%     
                            for(Carona c : lista) {
                            %>
								<div class="col-xs-1">
									<%=c.getId()%>
								</div>
								<div class="col-xs-2">
									<%=c.getDia()%>
								</div>
								<div class="col-xs-2">
									<%=c.getHora_saida()%>
								</div>
								<div class="col-xs-2">
									<%=c.getOrigem()%>
								</div>
								<div class="col-xs-2">
									<%=c.getDestino()%>
								</div>
								<div class="col-xs-3">
									<a href="RMotorista?idCarona=<%=c.getId()%>"
										class="btn btn-link">Candidatar</a>
								</div>
								<% 
                            }
                            %>
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