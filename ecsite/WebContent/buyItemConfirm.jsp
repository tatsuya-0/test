<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>BuyItemConfirm画面</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px; font-family; Verdana ,Helvetica,sans-self;
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
	margin: 30px ato;
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

	<div id="header">
		<div id="pr"></div>
	</div>

	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:form action="CartAction">

				<s:iterator value="CartList">
					<tr>
						<td>商品名</td>
						<td><s:property value="itemName" /></td>
					</tr>
					<tr>
						<td>値段</td>
						<td><s:property value="totalPrice" /><span>円</span></td>
					</tr>
					<tr>
						<td>購入個数</td>
						<td><s:property value="totalCount" /><span>個</span></td>
					</tr>
					<tr>
						<td>取得ポイント</td>
						<td><s:property value="totalpoint" /><span>ポイント</span>
					<tr>
						<td>支払い方法</td>
						<td><s:if test="payment == 1">
								<p>現金払い</p>
							</s:if> <s:elseif test="payment==2">
								<p>クレジット</p>
							</s:elseif></td>
					</tr>

						<input type="hidden" value="<s:property value="itemName"/>"name="itemName" />
							<input type="hidden"value="<s:property value="totalPrice"/>" name="totalPrice" />
							 <input type="hidden" value="<s:property value="totalCount"/>"name="totalCount" />
							 <input type="hidden"value="<s:property value="totalpoint" />" name="totalpoint" />
							  <input type="hidden" value="<s:property value="payment" />"name="payment" />
							  <input type="hidden" name="deleteFlg" value="1">

				</s:iterator>
				<tr>

					<td><br></td>
				</tr>

				<tr>
					<td><input type="button" value="戻る"
						onclick="submitAction('HomeAction')" /></td>
					<td><input type="button" value="購入"
						onclick="submitAction('BuyItemConfirmAction')" /></td>

			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>


</body>
</html>