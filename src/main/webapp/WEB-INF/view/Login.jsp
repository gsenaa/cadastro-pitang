<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	div {
		magin: auto;
		margin-top: 100px;
		display: flex;
		justify-content: center;
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
</style>
</head>
<body>
<div>
	<form action="login" method="post">
		E-mail: 
		<input type="email" name="login"><br>
		Senha: 
		<input type="password" name="password">
		<br>
		<input type="submit">
		<a href="/cadastropitang/cadastro">Nao sou cadastrado</a>
	</form>
	
	
</div>
</body>
</html>