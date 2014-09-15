<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta id="viewport" name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
<title>認証画面</title>
<link rel="stylesheet" href="/css/iphone.css" />
</head>
<body>
<div id="header" class="pre">
<c:if test="${not empty user}">
<c:out value="${nickName}" />
</c:if>
<c:if test="${empty user}">
<p>ログインしてません</p>
</c:if>
<h1>トップ画面</h1>

<a href="/index" id="backButton">戻る</a>
</div>
<ul>
	<li><a href="<c:out value="${google}" />"><img src="/img/id_google.png" class="ico" />Googleでログイン</a></li>
	<li><a href="<c:out value="${yahoo}" />"><img src="/img/id_yahoo.png" class="ico" />Yahoo! Japanでログイン</a></li>
	<li><a href="<c:out value="${mixi}" />"><img src="/img/id_mixi.png" class="ico" />mixiでログイン</a></li>
</ul>
</body>
</html>

