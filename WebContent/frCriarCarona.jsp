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
<%@page language="java" import="modelo.Logradouro"%>
<%@page language="java" import="java.util.ArrayList"%>
<%@page language="java" import="java.lang.Iterable"%>
<%@page language="java" import="modelo.Grupo"%>
</head>
<body>

	<% ArrayList<Veiculo> listaVeiculo = (ArrayList<Veiculo>) request.getAttribute("listaVeiculo");%>
	<% ArrayList<Logradouro> listaLogradouro = (ArrayList<Logradouro>) request.getAttribute("listaLogradouro");%>
	<% Grupo grupo = (Grupo) request.getAttribute("grupo");%>

	<div class="container">
		<form action="CCarona" method="post" class="well span8">
			<div class="row">
				<div class="span3">
					<h4>Registro</h4>
				</div>
				<div class="span5">
					<input type="hidden" name="idUsuario"
						value="<%=session.getAttribute("IdUsuario") %>" /> 
						<input type="hidden" name="idGrupo"
						value="<%=grupo.getId() %>" /> <label
						for="inputNome" class="col-sm-1 control-label">Data</label>
					<div class="col-sm-12">
						<input type="date" class="form-control" name="data"
							placeholder="00/00/0000">
					</div>
					<label for="inputEmail" class="col-sm-1 control-label">Hora</label>
					<div class="col-sm-12">
						<input type="time" class="form-control" name="hora"
							placeholder="00:00">
					</div>
					<br />
					<script>
            			function selecionatudo(){
            				
            				var selecionados = document.getElementById('veiculo');
            				
            				for(i=0; i<=selecionados.length-1; i++){
            				
            					selecionados.options[i].selected = true;
            				
            				}
            			}
						function selecionatudo2(){
            				
            				var selecionados = document.getElementById('logradouroOrigem');
            				
            				for(i=0; i<=selecionados.length-1; i++){
            				
            					selecionados.options[i].selected = true;
            				
            				}
            			}
						function selecionatudo3(){
            				
            				var selecionados = document.getElementById('logradouroDestino');
            				
            				for(i=0; i<=selecionados.length-1; i++){
            				
            					selecionados.options[i].selected = true;
            				
            				}
            			}
            		</script>
					<label for="inputNome" class="col-sm-1 control-label">Veículo</label>
					<select class="form-control" id="veiculo" name="veiculo"
						OnSubmit="selecionatudo();">
						<%
                            for(Veiculo c : listaVeiculo) {
                            %>
						<option value="<%=c.getId() %>"><%=c.getModelo() %>
							<%=c.getPlaca() %>
							<%=c.getCor() %></option>
						<%} %>
					</select> <label for="inputNome" class="col-sm-2 control-label">Logradouro
						de origem</label> 
					<select class="form-control"
						id="logradouroOrigem" name="logradouroOrigem"
						OnSubmit="selecionatudo2();">
						<%
                            for(Logradouro c : listaLogradouro) {
                            %>
						<option value="<%=c.getId() %>"><%=c.getCep() %>
							<%=c.getCidade() %>
							<%=c.getDistrito() %>
							<%=c.getEndereco() %>
							<%=c.getEstado() %></option>
						<%} %>
					</select> <label for="inputNome" class="col-sm-2 control-label">Logradouro
						de destino</label> 
					<select class="form-control"
						id="logradouroDestino" name="logradouroDestino"
						OnSubmit="selecionatudo3();">
						<%
                            for(Logradouro c : listaLogradouro) {
                            %>
						<option value="<%=c.getId() %>"><%=c.getCep() %>
							<%=c.getCidade() %>
							<%=c.getDistrito() %>
							<%=c.getEndereco() %>
							<%=c.getEstado() %></option>
						<%} %>
					</select>
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