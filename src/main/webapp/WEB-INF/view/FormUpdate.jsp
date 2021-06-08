<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="user?acao=none&id=${user.email}" method="post">
		Nome:
		<input type="text" name="nome" value="${user.name}">
		
		Email:
		<input type="text" name="email" readonly="readonly" value="${user.email}"><br><br>
		
		Senha:
		<input type="password" name="password">
		
		Telefone para contato (principal):<br>
		DDD:
		<input class="input-telefone" type="text" name="ddd1" value="${telephone2.ddd}">
		
		Número:
		<input class="input-telefone" type="text" name="telefone1" value="${telephone2.number}">
		
		Tipo:
		<select name="tipo1">
			  <option value="fixo">Fixo</option>
    		  <option value="Móvel">Móvel</option>
    	</select><br>
		
		Telefone para contato (secundário)<br>
		DDD:
		<input class="input-telefone" type="text" name="ddd2" value="${telephone.ddd}">
		
		Número:
		<input class="input-telefone" type="text" name="telefone2" value="${telephone.number}">
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