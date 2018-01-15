<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	
	<!-- CSS -->
	<link rel="stylesheet" href="template/css/bootstrap-theme.css">
	<link rel="stylesheet" href="template/css/bootstrap.css">
	<link rel="stylesheet" href="template/css/menu.css">
	
	<!-- JavaScript -->
	<script src="template/js/bootstrap.js"></script>

<%@page language="java" import="modelo.Logradouro"%>
<%@page language="java" import="modelo.Carona"%>
<%@page language="java" import="java.util.ArrayList"%>

<body>

	<% Carona carona = (Carona) request.getAttribute("idCarona");%>
	<% ArrayList<Logradouro> listaLogradouro = (ArrayList<Logradouro>) request.getAttribute("listaLogradouro");%>

	<div class="container">
		<form action="CParada" method="post" class="well span8">
			<div class="row">
				<div class="span3">
					<h4>Registro</h4>
				</div>
				<div class="span5">
				<%=carona.getId() %>
				<%=session.getAttribute("IdUsuario") %>
					<input type="hidden" name="idCarona" value="<%=carona.getId() %>" />
					<input type="hidden" name="idMotorista" value="<%=session.getAttribute("IdUsuario") %>" /> 
						<label for="inputNome" class="col-sm-1 control-label">E-mail</label>
					<div class="col-sm-12">
						<input type="text" class="form-control" name="e-mail"
							placeholder="E-mail">
					</div>
					<br/>
					<script>
						function selecionatudo(){
            				
            				var selecionados = document.getElementById('idLogradouro');
            				
            				for(i=0; i<=selecionados.length-1; i++){
            				
            					selecionados.options[i].selected = true;
            				
            				}
            			}

            		</script>
					 <label for="inputNome" class="col-sm-2 control-label">Logradouro
						de parada</label>
					<div class="col-sm-12"> 
					<select class="form-control"
						id="idLogradouro" name="idLogradouro"
						OnSubmit="selecionatudo();">
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