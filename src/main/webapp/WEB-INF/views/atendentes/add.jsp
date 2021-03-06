<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastrar Atendente</title>
	<c:url value="/" var="contextPath" />
	<link href="${contextPath}resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${contextPath}resources/css/layout-colors.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${contextPath}resources/css/main-style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${contextPath}resources/css/main.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<nav class="categories-nav">
		<ul class="container">
			<li class="category"><a href="">CHALLENGE ANDAMAS - SISTEMA DE SERVICE DESK</a></li>
		</ul>
	</nav>
	<header id="product-highlight" class="clearfix">
			<div id="product-overview" class="container">
				<h1 class="product-title">Cadastrar Atendente</h1>
			</div>
	</header>
	<div class="container">
		<form:form action="${s:mvcUrl('AC#gravar').build() }" method="post" commandName="atendente">
		    <div>
		        <label>Nome</label>
		        <form:input path="nome" />
		        <form:errors path="nome"/>
		    </div>
		    <br>
		    <button type="submit">Cadastrar</button>
		</form:form>
		<br>
		<br>
		<a href="/sistema-service-desk/">Voltar para Home</a>
		<a href="/sistema-service-desk/atendentes">Listar Atendentes</a>
	</div>
</body>
</html>