<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/alatanapizza.css">
<link rel="stylesheet" href="./css/PurchaceHistory.css">
<title>決済完了</title>




</head>
<body>
<jsp:include page="include_header.jsp" />

<div class="main">

<h3>
決済が完了しました。</h3>
<br>
お買い上げありがとうございます。
<br>
お届けまでしばらくお待ちください。

<br><a><br></a>
<a href='<s:url action="MyPageAction" />'>マイページ</a>
	<br>
<a href='<s:url action="HomeAction" />'>ホームに戻る</a>
</div>
	<jsp:include page="include_footer.jsp" />
</body>
</html>