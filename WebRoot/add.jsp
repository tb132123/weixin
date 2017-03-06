<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>add news</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="/ui/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/ui/flat-ui.css">
  </head>
  
  <body>
    	<h1>添加一则消息</h1>
    	<form action="/news/add" method="post">
    		
    	
    	<div class="row">
        <div class="col-md-12">
         
          <div class="form-group has-success">
            <label class="control-label" for="inputSuccess">标题:</label>
            <input type="text" class="form-control"  name="name">
            <label class="control-label" for="inputSuccess">图片地址:</label>
            <input type="text" class="form-control"  name="PUrl">
            <label class="control-label" for="inputSuccess">网页地址:</label>
            <input type="text" class="form-control"  name="Url">
            <input type="reset" value="重置" class="btn btn-primary">&nbsp<input type="submit" value="提交" class="btn btn-primary">
          </div>
          
        </div>
      </div><!-- /.row -->
    	</form>
  </body>
</html>
