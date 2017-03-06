<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>List news</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/ui/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/ui/flat-ui.css">
	
  </head>
  
  <body>
    	<h1>所有信息状态：</h1>
    	<table>
    	<tr>
    		<td>标题</td>
    		<td>网页地址</td>
    		<td>图片地址</td>
    		<td>&nbsp</td>
    	</tr>
    	<c:forEach items="${news}" var="news">
    		<tr>
    			<td>${news.title}</td>
    			
    			<td>${news.web_url}</td>
    			<td>${news.image_url}</td>
    			<td><a href="/news/edit/${news.id}">编辑</a></td>
    			<td><a href="/news/delete/${news.id}">删除</a></td>
    		</tr>
    	
    	</c:forEach>
    	</table>
    	<input type="button" value="添加消息" class="btn btn-primary" onclick="addnews()"/>
  </body>
  
  <script type="text/javascript">
  	function addnews(){
  		window.location.href="/add.jsp";
  	}
  
  </script>
</html>
