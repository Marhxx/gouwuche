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
<tr><td>商品名称</td><td>价格</td><td>操作</td></tr>
<%
Object o = request.getAttribute("list");
if(null == o){
	response.sendRedirect("QueryGoodsServlet");
	return;
}
 List<Goods> list = (List<Goods>)o;
for(Goods g :list){   
%>
<tr><td><%=g.getName() %></td><td><%=g.getBlance() %></td>

<td><a href="AddCart?id=<%=g.getId()%>">加入购物车</a></td>
</tr>
<%} %>
</table>
<a href="car">查看购物车</a>
</body>
</html>