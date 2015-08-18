<%@ include file="includePage.jsp" %>
<html>
<head>
<title>Greeting Seller Page</title></head>
<style>
  body { background: url(bear.jpg); 
  background-position: top = top center = center top = 50% 50%; 
    background-repeat: no-repeat;}
</style>
<body>

	<h3 color: yellow>Hello ${user.role.name} ${user.name}</h3>
	<form action="Controller" name="GetOrdersForm" method="post">
    <input type="hidden" name="command" value="GetOrders"/>
       
    <input type="submit" value="Get all Orders">

</form>
</body>
</html>

