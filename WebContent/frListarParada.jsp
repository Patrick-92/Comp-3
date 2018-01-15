<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="template/css/bootstrap-theme.css">
<link rel="stylesheet" href="template/css/bootstrap.css">
<link rel="stylesheet" href="template/css/menu.css">

<!-- JavaScript -->
<script src="template/js/bootstrap.js"></script>

<%@page language="java" import="modelo.Parada"%>
<%@page language="java" import="java.util.ArrayList"%>
</body>
<% ArrayList<Parada> lista = (ArrayList<Parada>) request.getAttribute("listaParadas");%>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Paradas</h3>
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
					<div class="col-xs-2">
                         			Id do Usuario
                           		</div>
                            	<div class="col-xs-4">
                                	Id do Logradouro
                            	</div>
                            	<div class="col-xs-4">
                                	Id da Carona
                            	</div>
					<div id="detail-1">
						<hr></hr>
						<div class="container">
							<div class="fluid-row">
								<%     
                            for(Parada c : lista) {
                            %>
                            	<div class="col-xs-2">
                         			<%=c.getUsuario()%>
                           		</div>
                            	<div class="col-xs-4">
                                	<%=c.getLogradouro()%>
                            	</div>
                            	<div class="col-xs-4">
                                	<%=c.getCarona()%>
                            	</div>
                            	<div class="col-xs-2">
                                	<a href="CNParada?idUsuario=<%=c.getUsuario()%>" class="btn btn-link">Cancelar carona</a>
                            	</div>
                            <% 
                            }
                            %>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</html>