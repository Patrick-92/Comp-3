<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Index</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- CSS -->
	<link rel="stylesheet" href="template/css/bootstrap-theme.css">
	<link rel="stylesheet" href="template/css/bootstrap.css">
	<link rel="stylesheet" href="template/css/menu.css">
	
	<!-- JavaScript -->
	<script src="template/js/bootstrap.js"></script>

</head>
<body>
<nav class="navbar navbar-default" target="iframe">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home.jsp" target="iframe">Carona</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="home.jsp" target="iframe">Home <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Grupo <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="frCriarGrupo.jsp" target="iframe">Criar</a></li>
            <li><a href="RGrupo?id=<%=session.getAttribute("IdUsuario") %>" target="iframe">Listar</a></li>
          </ul>
        </li>
      </ul>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuário <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="frAlterarUsuario.jsp" target="iframe">Alterar</a></li>
            <li><a href="frListarUsuario.jsp" target="iframe">Excluir</a></li>
          </ul>
        </li>
      </ul>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Veículo <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="frCriarVeiculo.jsp" target="iframe">Criar</a></li>
          </ul>
        </li>
      </ul>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Logradouro <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="frCriarLogradouro.jsp" target="iframe">Criar</a></li>
            <li><a href="frListarLogradouro.jsp" target="iframe">Listar</a></li>
          </ul>
        </li>
      </ul>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Carona <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="RParadaUsuario?idUsuario=<%=session.getAttribute("IdUsuario") %>" target="iframe">Listar</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        							<li><a href="login.jsp">Logout</a></li>
        							</li>
      							</ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div align="center" class="ui segment">
  		
  		<iframe name="iframe" width=90% height=768 frameborder='0' src='home.jsp'></iframe>
  		
	</div>
</body>
</html>