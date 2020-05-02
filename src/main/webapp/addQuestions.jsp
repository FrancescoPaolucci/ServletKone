<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
<h1>HERE YOU CAN ADD YOUR OWN QUESTIONS</h1>
<form action="./addQuestion" method="post">
  <label for="fname">Question:</label><br>
  <input type="text" id="question" name="question"><br>
  <input type="submit" value="Submit">
</form> 
</div>
</body>
</html>