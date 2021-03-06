<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de grupos</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="template/css/bootstrap-theme.css">
<link rel="stylesheet" href="template/css/bootstrap.css">
<link rel="stylesheet" href="template/css/menu.css">

<!-- JavaScript -->
<script src="template/js/bootstrap.js"></script>

<%@page language="java" import="modelo.Grupo"%>
<%@page language="java" import="java.util.ArrayList"%>

</head>
<body>
	<% ArrayList<Grupo> lista = (ArrayList<Grupo>) request.getAttribute("lista");%>
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
					<div class="col-xs-3">Descri��o</div>
					<div class="col-xs-2">Regras</div>
					<div class="col-xs-1">Limite</div>
					<div id="detail-1">
						<div class="fluid-row">
							<hr></hr>
							<div class="container">
								<div class="fluid-row">
									<%     
                            for(Grupo c : lista) {
                            %>
									<div class="col-xs-3">
										<%=c.getDescricao()%>
									</div>
									<div class="col-xs-2">
										<%=c.getRegras()%>
									</div>
									<div class="col-xs-1">
										<%=c.getLimite()%>
									</div>
									<div class="col-xs-1">
										<a href="frAlterarGrupo.jsp?idGrupo=<%=c.getId()%>"
											class="btn btn-link">Alterar</a>
									</div>
									<div class="col-xs-1">
										<a href="RUsuario?idGrupo=<%=c.getId()%>" class="btn btn-link">Membros</a>
									</div>
									<div class="col-xs-1">
										<a href="IGrupo?idGrupo=<%=c.getId()%>" class="btn btn-link">Inativar</a>
									</div>
									<div class="col-xs-1">
										<a
											href="SGrupo?idGrupo=<%=c.getId()%>&idUsuario=<%=session.getAttribute("IdUsuario")%>"
											class="btn btn-link">Sair</a>
									</div>
									<div class="col-xs-1">
										<a href="RCaronaGrupo?idGrupo=<%=c.getId()%>" class="btn btn-link">Caronas</a>
									</div>
									<div class="col-xs-1">
										<a href="RComponentesCarona?idUsuario=<%=session.getAttribute("IdUsuario") %>&idGrupo=<%=c.getId()%>" class="btn btn-link">Criar</a>
									</div>
									<% 
                            }
                            %>
								</div>
								<div class="col-xs-11">
							<button type="button" class="btn btn-danger pull-right"
								onClick="history.go(-1)">Voltar</button>
								</div>
							</div>
						</div>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>