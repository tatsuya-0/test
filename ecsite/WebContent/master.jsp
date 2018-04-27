<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<title>管理画面</title>
<style type="text/css">

body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
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
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}
</style>


</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>

	<div id="main">
		<div id="top">
			<p>master</p>
		</div>

		<div>




			</div>
				<table>
					<s:iterator value="buyItemDTOList"  status="st">
			<s:form  id="form" action="MasterAction" >
			<tr>
			<td>

					<tr>
					<td>
					<h3><s:property value="id "/><s:hidden value="%{id}" name="id"/></h3>
					</td>
					</tr>

						<tr>
							<td>
								<h3>
									<s:property value="itemName" />
								</h3>
							</td>
						</tr>

						<tr>
							<td><span>在庫</span></td>
							<td><s:property value="item_stock" /></td>
						</tr>

						<tr>
						<td><span>&yen</span><s:property value="itemPrice"/>
						</td>
						</tr>

						<tr>
							<td><span>商品在庫追加</span></td>
							<td>	<select name="stock">
							<s:iterator status="st" begin="1" end="1000">
								<option value='<s:property value="#st.count"/>' />
								<s:property value="#st.count" />
							</s:iterator>
						</select></td>
						</tr>
					<tr>
						<td><button  type="submit"   name="stockFlg"  >追加</button></td>
					</tr>
			</s:form>
					</s:iterator>
				</table>

			<div>
				<p>
					<a href='<s:url action="GoHomeAction" />'>home</a>
				</p>
			</div>
		</div>

	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>