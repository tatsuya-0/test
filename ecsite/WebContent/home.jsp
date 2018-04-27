<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Home画面</title>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	font-family: Verdava, Helvetica, sans-self;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}

#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}

#text-center {
	display: inline-block;
	text-align: center;
}
</style>
</head>
<body>
	<diV id="header">
		<div id="pr"></div>
	</diV>
	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>
		<p class="guest">
			<s:if test="#session.login_user_id!=null">
			<p>	ようこそ！<s:property value="#session.login_user_id" />さん</p>
			<p>
			<a href='<s:url action="MyPageAction"/>'> マイぺージ</a>



			<p>ログアウトする場合は
				<a href='<s:url action="LogoutAction" />'>こちら</a></p>
			</s:if><s:else >
					<p>ようこそ！ゲストさん</p>
			<s:form action="HomeAction">
				<s:submit value="Login" />
			</s:form>
			</s:else>

		<div id="text-center">
			<s:form action="GoItemAction">
			<s:submit value="商品一覧"/>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>