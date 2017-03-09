<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>

<html lang="en">
<head>
<title>Maven + Spring MVC</title>
 
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
 
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Spring 3 MVC Project</a>
	</div>
  </div>
</nav>
 <body>
<div class="jumbotron">

	<p>
	Başvuru Formu
    </p>
    <div class="alert alert-${type}"  >
  <strong>${allert}</strong>${message} ${bilgi}
</div>
    
  <div class="container">
	
    <div class="row">
	<form   action="ekle" method="POST" name="form" >
	
	
			<div class="form-group">
    		<label for="isim">İsim Soyisim:</label>
 		   <input type="text" class="form-control" name="name"/>
	  		</div>
	  		<div class="form-group">
			<label for="tc">TC Kimlik:</label>
 		   <input type="text" class="form-control" name="tc" />
 		   </div>
 		   
 		   <div class="form-group">
			<label for="adres">Adres:</label>
 		   <input type="text" class="form-control" name="adres" />
 		   </div>
 		   
 		   <div class="form-group">
			<label for="tel">Telefon No:</label>
 		   <input type="tel" class="form-control" name="tel" />
 		   </div>
 		   
 		   <div class="form-group">
			<label for="email">E-Posta:</label>
 		   <input type="email" class="form-control" name="email" />
 		   </div>
 		   
 		   <div class="form-group">
			<label for="dt">Doğum Tarihi:</label>
 		   <input type="date" class="form-control" value="1000-01-01" name="dt" />
 		   </div>
 		   
 		   
 		    <div class="form-group">
			<label for="perakende">PERAKENDE TİCARETİ İLE UĞRAŞTINIZ MI? </label>
 		   <input type="text" class="form-control" name="perakende" />
 		   </div>
 		   
 		    <div class="form-group">
			<label for="sebep">LOKUMCU BABA’YI TERCİH ETMENİZİN SEBEBİ NEDİR?</label>
 		   <input type="text" class="form-control" name="sebep" />
 		   </div>
 		   
 		   
 		    <div class="form-group">
			<label for="il">HANGİ İL/İLÇE/SEMT İÇİN LOKUMCU BABA İŞLETMECİLİĞİ DÜŞÜNÜYORSUNUZ? </label>
 		   <input type="text" class="form-control" name="il" />
 		   </div>
 		   
 		      <div class="form-group">
			<label for="miktar">YATIRIM MİKTARINIZ NEDİR? </label>
 		   <input type="number" class="form-control" value="0" name="miktar" />
 		   </div>
 		   
 		     <div class="form-group">
			<label for="ek">Eklemek İstedikleriniz</label>
			<textarea class="form-control" rows="5" name="ek"></textarea>
 			 </div>
	  		</div>
		<a href="#section1"><input type="submit" class="btn btn-primary" value="EKLE" />	</a>
		</form>
</div>

	</div>

 
<div class="container">
  <hr>
  <footer>
	<p>&copy; Hatip Aksünger 2017</p>
  </footer>
</div>
 
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>