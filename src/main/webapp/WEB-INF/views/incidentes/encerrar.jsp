<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="main.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Encerrar Incidente</title>
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
			<h1 class="product-title">Incindente Encerrado!</h1>
		</div>
	</header>
	<div class="container">
		<br>
		<br>
		<a href="/sistema-service-desk/">Voltar para Home</a>
		<a href="/sistema-service-desk/incidentes">Listar Incidentes</a>
		<a href="/sistema-service-desk/incidentes/add">Registrar Incidente</a>
	</div>
</body>
</html>