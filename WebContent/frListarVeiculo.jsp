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

<%@page language="java" import="modelo.Veiculo"%>
<%@page language="java" import="java.util.ArrayList"%>

</head>
<body>
	<% ArrayList<Veiculo> lista = (ArrayList<Veiculo>) request.getAttribute("lista");%>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Veículos</h3>
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
					<div id="detail-1">
						<hr></hr>
						<div class="container">
							<div class="fluid-row">
								<%     
                            for(Veiculo c : lista) {
                            %>
                            	<div class="col-xs-1">
                         			<%=c.getId()%>
                           		</div>
                            	<div class="col-xs-3">
                                	<%=c.getModelo()%>
                            	</div>
                            	<div class="col-xs-3">
                                	<%=c.getPlaca()%>
                            	</div>
                            	<div class="col-xs-3">
                                	<%=c.getCor()%>
                            	</div>
                            	<div class="col-xs-2">
                                	<a href="frAlterarVeiculo.jsp?idVeiculo=<%=c.getId()%>" class="btn btn-link">Alterar</a>
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
</body>
</html>