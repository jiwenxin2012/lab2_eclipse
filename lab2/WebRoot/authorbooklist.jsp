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
    
    <title>My JSP 'booklist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="Book_list_Page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<h2 >---1120310729 HIT-CS---</h2> <br>
    <h2 align = "CENTER" >---The Author's Book List---</h2> <br>
    
    <td> 
    	<s:form action = "BACK">
    	<s:submit value = "Back"/>
    	</s:form>
    </td>
    <table border = 1 align = "CENTER" >
    	<tr>
    		<td> AuthorName </td>
    		<td> Content </td>
    		<td> ISBN </td>
    		<td> Legend </td>
    	</tr>
    	<s:iterator value = "books" id = "i" status = "struts" >
    			<tr>
    				<td> <s:property value = "#i.author.name"/> </td>
    				<td> <s:property value = "#i.title"/> </td>
    				<td> <s:property value = "#i.isbn"/> </td>
    				<td>
    					<s:form id = "delete" action = "QUERY_DETAIL" >
    					<s:submit value = "delete">
    						<s:hidden name = "isbn" value = "#i.isbn"/>
    						</s:submit>>
    					</s:form>
    					<s:a href = "%{URL}" >
    					More Detail
    					</s:a>
    				</td>
    				<td>
    					--
    				</td>
    			</tr>
    	</s:iterator>
    </table>
  </body>
</html>
