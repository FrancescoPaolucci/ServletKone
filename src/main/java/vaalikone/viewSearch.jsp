<%@ page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
</head>
<body>
	<table width="700px" align="center" style="border: 1px solid #000000;">
		<tr>
			<td colspan=4 align="center" style="background-color: teal"><b>Search Result</b></td>
		</tr>
		<tr style="background-color: lightgrey;">
			<td><b>Id</b></td>
			<td><b>Sukunimi</b></td>
			<td><b>Etunimi</b></td>
			<td><b>puolue</b></td>
			<td><b>Kotipaikkakunta</b></td>
			<td><b>Ika</b></td>
			<td><b>MiksiEdus</b></td>
			<td><b>MitaAsioita</b></td>
			<td><b>Ammatti</b></td>
		</tr>
		<%
			int count = 0;
			String color = "#F9EBB3";
			if (request.getAttribute("piList") != null) {
				ArrayList al = (ArrayList) request.getAttribute("piList");
				System.out.println(al);
				Iterator itr = al.iterator();
				while (itr.hasNext()) {

					if ((count % 2) == 0) {
						color = "#eeffee";
					}
					count++;
					ArrayList pList = (ArrayList) itr.next();
		%>
		<tr style="background-color:<%=color%>;">
			<td><%=pList.get(0)%></td>
			<td><%=pList.get(1)%></td>
			<td><%=pList.get(2)%></td>
			<td><%=pList.get(3)%></td>
			<td><%=pList.get(4)%></td>
			<td><%=pList.get(5)%></td>
			<td><%=pList.get(6)%></td>
			<td><%=pList.get(7)%></td>
			<td><%=pList.get(8)%></td>
		</tr>
		<%
			}
			}
			if (count == 0) {
		%>
		<tr>
			<td colspan=4 align="center" style="background-color: #eeffee"><b>No
					Record Found..</b></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>