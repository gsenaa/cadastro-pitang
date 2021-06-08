<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	form {
		margin: auto;
		margin-top: 30px;
		width: 55%;
	}
	
	input {
		width: 100%;
  		padding: 12px 20px;
  		margin: 8px 0;
  		display: inline-block;
  		border: 1px solid #ccc;
  		border-radius: 4px;
  		box-sizing: border-box;
	}
	
	.input-telefone {
		width: 33%;
  		padding: 12px 20px;
  		margin: 8px 0;
  		display: inline-block;
  		border: 1px solid #ccc;
  		border-radius: 4px;
  		box-sizing: border-box;
	}
	
	.input-submit {
		height: 50px
	}
</style>
</head>
<body>
<div>
	<form action="cadastro" method="post">
		Nome:
		<input type="text" name="nome">
		
		E-mail:
		<input type="email" name="email">
		
		Senha:
		<input type="password" name="password">
		
		Telefone para contato (principal):<br>
		DDD:
		<input class="input-telefone" type="text" name="ddd1">
		
		Número:
		<input class="input-telefone" type="text" name="telefone1">
		
		Tipo:
		<select name="tipo1">
			  <option value="fixo">Fixo</option>
    		  <option value="Móvel">Móvel</option>
    	</select><br>
		
		Telefone para contato (secundario)<br>
		DDD:
		<input class="input-telefone" type="text" name="ddd2">
		
		Número:
		<input class="input-telefone" type="text" name="telefone2">
		Tipo:
		<select name="tipo2">
			  <option value="fixo">Fixo</option>
    		  <option value="Móvel">Móvel</option>
    	</select>
		
		
		<input class="input-submit" type="submit">
	</form>
</div>
</body>
</html>