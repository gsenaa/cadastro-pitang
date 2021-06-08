<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		magin: auto;
		display: flex;
		justify-content: center
	}
	.div-itens {
		margin-top: 15px;
		display: flex;
		justify-content: center
	}
</style>
</head>
<body>
	<div>
		<h1>Lista de Users</h1>
	</div>
	<c:forEach items="${users}"  var="user">
		<div class="div-itens">
			<p>${user.name} | ${user.email} |
			<a href="/cadastropitang/user?acao=remover&id=${user.email}">Remover</a>
			<a href="/cadastropitang/user?acao=atualizar&id=${user.email}">Atualizar</a>
			</p>
		</div>
	</c:forEach>
	<div>
		<a href="/cadastropitang/cadastro">Cadastrar outro User</a>
	</div>
	
</body>
</html>