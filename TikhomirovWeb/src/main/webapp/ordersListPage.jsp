<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<body>
	<h2>Hello Buyer!!!!   ${user.name}</h2>
	<form action="Controller" name="LoginForm" method="post">
    <input type="hidden" name="command" value="makeOrder"/>
    
    <input name="login" type="text"/><br/>
    
    <input name="password" type="password"/><br/>
   
    <input type="submit" value="make an order">

</form>
</body>
</html>
