<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
<%@page import="persist.Ehdokkaat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%List <Ehdokkaat> e=(List <Ehdokkaat>)request.getAttribute("Ehdokkaat"); %>



<body>
<table>
<form action="admin" method="get">
<tr><td>Id</td><td>Sukunimi</td><td>Nimi</td><td>Puolue</td><td>Kotipaikkakunta</td><td>Ika</td><td>MiksiEdus</td><td>MitaAsioita</td><td>Ammatti</td></tr>
<tr>
<td><input type="text" name="Id" ></td>
<td><input type="text" name="Sukunimi"></td>
<td><input type="text" name="Etunimi"></td>
<td><input type="text" name="Puolue"></td>
<td><input type="text" name="Kotipaikkakunta"></td>
<td><input type="text" name="Ika"></td>
<td><input type="text" name="MiksiEdus"></td>
<td><input type="text" name="MitaAsioita"></td>
<td><input type="text" name="Ammatti"></td>
<td><input type="submit" name="Add" value="Add"></td>
<td></td>
</tr></form>
<% for(Ehdokkaat eh:e){ %>
<form action="admin" method="get">
<tr>
<td><input type="text" readonly name="Id" value=<%=eh.getEhdokasId() %>></td>
<td><input type="text" name="Sukunimi" value=<%=eh.getSukunimi() %>></td>
<td><input type="text" name="Etunimi" value=<%=eh.getEtunimi() %>></td>
<td><input type="text" name="Puolue" value=<%=eh.getPuolue() %>></td>
<td><input type="text" name="Kotipaikkakunta" value=<%=eh.getKotipaikkakunta() %>></td>
<td><input type="text" name="Ika" value=<%=eh.getIka() %>></td>
<td><input type="text" name="MiksiEdus" value=<%=eh.getMiksiEduskuntaan() %>></td>
<td><input type="text" name="MitaAsioita" value=<%=eh.getMitaAsioitaHaluatEdistaa() %>></td>
<td><input type="text" name="Ammatti" value=<%=eh.getAmmatti() %>></td>
<td><input type="submit" name="Edit" value="Edit"></td>
<td><input type="submit" name="Del" value="Delete"></td>

</tr>
</form>
<%}%>

</table>




</body>
</html>