<%@ include file="includePage.jsp" %>
<html>
<head>
<title>Traider Greeting Page</title></head>
<style>
  body { background: url(bear.jpg); 
  background-position: top = top center = center top = 50% 50%; 
    background-repeat: no-repeat;
    width: 70%}
</style>
<body>

	<h3>Hello ${user.user_name}</h3>
	
	<a href="Controller?command=GetOffers">
	<fmt:message key="traider.greeting.page.get.offers" bundle="${one}" /> </a><br/>
			
	<a href="Controller?command=GetOrders"><fmt:message
	key="traider.greeting.page.get.orders" bundle="${one}" /> </a><br/>
			
	<a href="Controller?command=addOrder"><fmt:message
	key="traider.greeting.page.add.order" bundle="${one}" /> </a><br/>
			
	<a href="Controller?command=addOffer"><fmt:message
	key="traider.greeting.page.add.offer" bundle="${one}" /> </a><br/>
			
</body>
</html>

