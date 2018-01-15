<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- CSS -->
	<link rel="stylesheet" href="template/css/bootstrap-theme.css">
	<link rel="stylesheet" href="template/css/bootstrap.css">
	<link rel="stylesheet" href="template/css/menu.css">
	
	<!-- JavaScript -->
	<script src="template/js/bootstrap.js"></script>
	<%@page language="java" import="modelo.Usuario"%>
	
	<script type="text/javascript">
			/* Máscaras ER */
			function mascara(o,f){
				v_obj=o
				v_fun=f
				setTimeout("execmascara()",1)
			}
			function execmascara(){
				v_obj.value=v_fun(v_obj.value)
			}
			function mtel(v){
				v=v.replace(/\D/g,""); //Remove tudo o que não é dígito
				v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
				v=v.replace(/(\d)(\d{4})$/,"$1-$2"); //Coloca hífen entre o quarto e o quinto dígitos
				return v;
			}
			function id( el ){
				return document.getElementById( el );
			}
			window.onload = function(){
				id('telefone').onkeypress = function(){
					mascara( this, mtel );
				}
			}
		</script>

</head>
<body>
<div class="container">
	<% Usuario usuario = (Usuario) request.getAttribute("usuario");%>
	<form  action="UUsuarioConvidado" method="post" class="well span8">
        <div class="row">
            <div class="span3">
                <h4>Registro</h4>               
            </div>
    
            <div class="span5">
            
                <input type="hidden" name="idUsuario" value="<%=usuario.getId() %>" />
                <label for="inputNome" class="col-sm-1 control-label">Nome</label>
    			<div class="col-sm-12">
      				<input type="text" class="form-control" name="nome" placeholder="Nome">
    			</div>
    			<label for="inputTelefone" class="col-sm-1 control-label">Telefone</label>
    			<div class="col-sm-12">
      				<input type="text" class="form-control" id="telefone" name="telefone" minlength="14" maxlength="15" placeholder="(XX)XXXXX-XXXX" required>
    			</div>
    			<label for="inputSenha" class="col-sm-1 control-label">Senha</label>
    			<div class="col-sm-12">
      				<input type="password" class="form-control" name="senha" placeholder="Senha">
    			</div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary pull-right" type="submit">Criar</button>
            <button type="reset" class="btn btn-default pull-right" type="submit">Limpar</button>
            <button type="button" class="btn btn-danger pull-right" onClick="history.go(-1)">Cancelar</button>
        </div>
    </form>
</div>
</body>
</html>