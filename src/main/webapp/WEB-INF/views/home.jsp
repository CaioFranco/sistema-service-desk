<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sistemas Service Desk</title>
	<c:url value="/" var="contextPath" />
	<link href="${contextPath}resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${contextPath}resources/css/layout-colors.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${contextPath}resources/css/main-style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${contextPath}resources/css/main.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body >
	<nav class="categories-nav">
		<ul class="container">
			<li class="category"><a href="">CHALLENGE ANDAMAS - SISTEMA DE SERVICE DESK</a></li>
		</ul>
	</nav>
	<header id="product-highlight" class="clearfix">
		<div id="product-overview" class="container">
			<h1 class="product-title">SISTEMA DE SERVICE DESK</h1>
		</div>
	</header>
	<div class="container">
		<section class="summary">
			<ul>
				<li>
					<h3>Abrir Incidente <a href="/sistema-service-desk/incidentes/add">clique aqui</a>.</h3>
				</li>
				<li>
					<h3>Listar incidentes <a href="/sistema-service-desk/incidentes">clique aqui</a>.</h3>
				</li>
			</ul>
			<ul>
				<li>
					<h3>Cadastrar Cliente <a href="/sistema-service-desk/clientes/add">clique aqui</a>.</h3>
				</li>
				<li>
					<h3>Listar Clientes <a href="/sistema-service-desk/clientes">clique aqui</a>.</h3>
				</li>
			</ul>
			<ul>
				<li>
					<h3>Cadastrar Atendente <a href="/sistema-service-desk/atendentes/add">clique aqui</a>.</h3>
				</li>
				<li>
					<h3>Listar Atendentes <a href="/sistema-service-desk/atendentes">clique aqui</a>.</h3>
				</li>
			</ul>
		</section>
	</div>
</body>
</html>