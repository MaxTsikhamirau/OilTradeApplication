<%@ include file="includePage.jsp" %>
<html>
<head>


<body>
<h3>Login PAGE</h3>
	
	<form action="Controller" name="LoginForm" method="post">
    <input type="hidden" name="command" value="LogIn"/>
   
    <input name="login" type="text"/><br/>
   
    <input name="password" type="password"/><br/>
   
    <input type="submit" value="LOGIN">

</form>
</body>
</html>
