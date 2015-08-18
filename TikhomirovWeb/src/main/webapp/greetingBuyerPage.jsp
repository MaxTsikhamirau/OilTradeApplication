<%@ include file="includePage.jsp"%>
<html>
<head>
<title>Greeting Buyer Page</title>
</head>
<style>
body {
	background: url(bull.jpeg);
	background-position: top= top center= center top= 50% 50%;
	background-repeat: no-repeat;
}
</style>
<body>

	<h3 color: yellow>Hello ${user.role.name}${user.name}</h3>

	<form action="Controller" name="GetOffersForm" method="post">
		<input type="hidden" name="command" value="GetOffers" /> 
		<input type="submit" value="Get all Offers">
	</form>

</body>
</html>
