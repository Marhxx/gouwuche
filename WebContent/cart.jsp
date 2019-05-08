<%@page import="java.util.Map"%>
<%@page import="com.qhit.beans.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr><td>商品名称</td><td>价格</td><td>数量</td><td>操作</td></tr>
<%
Object o = session.getAttribute("cart");
Map<String,Goods> map = (Map<String,Goods>)o;
double sum  = 0;
for(Goods g : map.values()){
	sum += g.getBlance() * g.getNum();
	String.format(sum+"", "%d2");
%>
<tr><td><%=g.getName() %></td><td><%=g.getBlance() %></td><td><%=g.getNum() %></td>

<td><a href="RemoveCart?id=<%=g.getId()%>">删除</a></td>
</tr>
<%} %>
</table>
总价格: <%=sum %>
</body>
</html>