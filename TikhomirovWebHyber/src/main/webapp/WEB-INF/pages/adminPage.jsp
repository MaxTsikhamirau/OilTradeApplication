<%@ include file="includePage.jsp" %>
<html>
<head>
<title>Admin Page</title></head>
<style>
  
</style>
<body>

	<h3 color: yellow>Hello ${user.name} Admin Page</h3>
	<a href="Controller?command=GetOffers"><fmt:message
			key="traider.greeting.page.get.offers" bundle="${one}" /> </a><br/>
	<a href="Controller?command=GetOrders"><fmt:message
			key="traider.greeting.page.get.orders" bundle="${one}" /> </a><br/>
			<a href="Controller?command=addOrder"><fmt:message
			key="traider.greeting.page.add.order" bundle="${one}" /> </a><br/>
			<a href="Controller?command=addOffers"><fmt:message
			key="traider.greeting.page.add.offer" bundle="${one}" /> </a><br/>
			
</body>
</html>

