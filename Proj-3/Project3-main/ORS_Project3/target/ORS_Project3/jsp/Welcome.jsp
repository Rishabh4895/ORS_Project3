<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Rays Technologies</title>
    <link href= "<%=ORSView.APP_CONTEXT%>/img/title.png" rel= "icon" type="icon">
    <style>
    .p1 
{
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/welcome.jpg');
	background-size: 100%;
	background-repeat: no-repeat;
	background-attachment: fixed; background-size: cover;
	background-position: center top;
}
    </style>
</head>
<body class = "p1">
	<form action = "<%=ORSView.WELCOME_CTL%>">

<%@include file="Header.jsp"%>
  <center><%-- 
		<img alt="Online Result System" src="<%=ORSView.APP_CONTEXT%>/img/bg-01.jpg" height="300" width="600">
		 --%><br>
		 <br><br><br><br><br><br><br><br><br><br>
		 <h1 style="color: white;"><b>Welcome to ORS</b></h1>
	</center>
<%@include file="Footer.jsp"%>
	</form>
</body>
</html>