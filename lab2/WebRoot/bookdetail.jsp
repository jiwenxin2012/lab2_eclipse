<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    

  </head>
  
  <body>
  	<base href="<%=basePath%>">
    
    <title>My JSP 'bookinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="Book_Information_page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<h2  >---1120310729 HIT-CS---</h2> <br>
	<h2 align = "CENTER" >---The Author and Book Detail Information---</h2> <br>
    <td> 
    	<s:form action = "QUERY">
    	<s:submit value = "Back"/>
    	</s:form>
    </td>
    Title:   		<s:property value = "book_info.title"/> <br>
    ISBN:  			<s:property value = "book_info.isbn"/> <br>
    Publish By:  	<s:property value = "book_info.publisher"/> <br>
    Publish Time:	<s:property value = "book_info.publish_date"/> <br>
    Price($): 			<s:property value = "book_info.price"/> <br>
	Author: 		<s:property value = "book_info.author.name"/>***Age***<s:property value = "book_info.author.age"/>***Country***<s:property value = "book_info.author.country"/> <br>
	<td> 
    	<s:form action = "DELETE">
    	<s:submit value = "InformationDelete"/>
    	</s:form>
    </td>
  </body>
</html>
