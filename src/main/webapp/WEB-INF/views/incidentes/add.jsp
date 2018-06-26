<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registrar Incidente</title>
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
				<h1 class="product-title">Registrar Incidente</h1>
			</div>
	</header>
	<div class="container">
		<form:form action="${s:mvcUrl('IC#gravar').build() }" method="post" commandName="incidente">
	   	    <div class="container">
		        <label>Cliente</label>
		        <select name="idCliente">
		        <c:forEach items="${clientes}" var="cliente">
	        		<option value="${cliente.id}">${cliente.nome}</option>
	    		</c:forEach>
			  	</select>
		    </div>
		    <br>
	   	    <div class="container">
		        <label>Atendente</label>
		        <select name="idAtendente">
		        <c:forEach items="${atendentes}" var="atendente">
	        		<option value="${atendente.id}">${atendente.nome}</option>
	    		</c:forEach>
			  	</select>
		    </div>
		    <br>
		    <div class="container">
		        <label>Descrição</label>
		        <form:textarea rows="5" cols="25" path="descricao"/>
		        <form:errors path="descricao"/>
		    </div>
		    <br>
		    <button type="submit">Registrar</button>
		</form:form>
		<br>
		<br>
		<a href="/sistema-service-desk/">Voltar para Home</a>
		<a href="/sistema-service-desk/incidentes">Listar Incidentes</a>
	</div>
</body>
</html>