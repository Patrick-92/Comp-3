<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Grupo</title>

	<!-- CSS -->
	<link rel="stylesheet" href="template/css/bootstrap-theme.css">
	<link rel="stylesheet" href="template/css/bootstrap.css">
	<link rel="stylesheet" href="template/css/menu.css">
	
	<!-- JavaScript -->
	<script src="template/js/bootstrap.js"></script>
	
</head>
<body>
	<div class="container">
	<form  action="UGrupo" method="post" class="well span8">
        <div class="row">
            <div class="span3">
                <h4>Registro</h4>               
            </div>
            <div class="span5">
            	<input type="hidden" name="idGrupo" value="<%=request.getParameter("idGrupo") %>" />
                <label for="inputNome" class="col-sm-1 control-label">Nome</label>
    			<div class="col-sm-12">
      				<input type="text" class="form-control" name="nome" placeholder="Nome">
    			</div>
    			<label for="inputTelefone" class="col-sm-1 control-label">Descrição</label>
    			<div class="col-sm-12">
      				<input type="text" class="form-control" name="descricao" placeholder="Telefone">
    			</div>
    			<label for="inputTelefone" class="col-sm-1 control-label">Limite</label>
    			<div class="col-sm-12">
      				<input type="text" class="form-control" name="limite" placeholder="Telefone">
    			</div>
    		</div>
            <br>
            <button type="submit" class="btn btn-primary pull-right" type="submit">Alterar</button>
            <button type="reset" class="btn btn-default pull-right" type="submit">Limpar</button>
            <button type="button" class="btn btn-danger pull-right" onClick="history.go(-1)">Cancelar</button>
        </div>
    </form>
</div>
</body>
</html>