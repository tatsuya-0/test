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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>カート画面</title>

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
	width: 100%;
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
	height: 500px auto;
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
	margin-top: 20px auto;
}

#text-center {
	display: inline-block;
	text-align: center;
}
</style>
<script type="text/Javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
	</script>
</head>
<body>
	<diV id="header">
		<div id="pr"></div>
	</diV>
	<div id="main">
		<div id="top">
			<p>cart</p>
		</div>
		<s:if test="CartList==null">
			<h3></h3>
		</s:if>
		<s:elseif test="message==null">
			<h3>カートの中は以下になります</h3>
			<table border="1">
				<tr>
					<th></th>
					<th>商品名</th>
					<th>値段</th>
					<th>購入個数</th>
					<th>ポイント</th>
					<th>支払い方法</th>
				</tr>
				<s:form action="CartAction">

					<s:iterator value="CartList" status="st" >

						<tr>
							<td><s:checkbox name="checklist"  value="0" fieldValue="%{id}"/>

							<td><s:property value="itemName" /></td>
							<td><s:property value="totalPrice" /><span>円</span></td>
							<td><s:property value="totalCount" /><span>個</span></td>
							<td><s:property value="totalpoint" /><span>ポイント</span></td>
							<td><s:if test="payment == 1">
									<p>現金払い</p>
								</s:if> <s:elseif test="payment==2">
									<p>クレジット</p>
								</s:elseif></td>
						</tr>


					</s:iterator>

					<tr>
						<td><s:submit value="削除"/>
							</td>
					</tr>
			</s:form>
		<s:form action="CartCompleteAction">
			<tr>
				<td><s:submit value="購入確認"  /></td>
			</tr>
		</s:form>
			</table>
		</s:elseif>

		<s:if test="message!=null">
			<h3>
				<s:property value="message" />
			</h3>
		</s:if>



		<div id="text-right">
			<p>
				商品画面へ戻る場合は<a href='<s:url action="GoItemAction"/>'>こちら</a>
			</p>
			<p>
				ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a>
			</p>
			<p>
			<a href='<s:url action="MyPageAction"/>'> マイぺージ</a>
			</p>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>







</body>
</html>