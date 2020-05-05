<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
<%@page import="persist.Kysymykset"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link href="style.css" rel="stylesheet" type="text/css">
</head>

<%List <Kysymykset> k=(List <Kysymykset>)request.getAttribute("Kysymykset"); %>



<body>
<table>
<form action="admin" method="get">
<tr><td>Id</td><td>Kysymys</td>
<td><input type="text" name="kysymysId" ></td>
<td><textarea name="kysymys" placeholder='Insert a new Question'> </textarea></td>
<td><input type="submit" name="Add" value="Add"></td>
<td></td>
</tr></form>
<% for(Kysymykset eh:k){ %>
<form action="admin" method="get">
<tr>
<td><input class = "Idfield" type="text" readonly name="kysymysId" value=<%=eh.getKysymysId() %>></td>
<td><textarea name="kysymys" class="textarea"> <%=eh.getKysymys() %></textarea></td>
<td><input class = "buttonedit" type="submit" name="Edit" value="Edit">
<input class = "buttonedel"  type="submit" name="Del" value="Delete"></td>
</tr>
</form>
<%}%>
</table>




</body>
</html>