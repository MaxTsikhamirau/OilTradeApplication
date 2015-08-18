<%@ include file="includePage.jsp" %>
<html>

<body>
	<h3 color: yellow>${user.name}</h3>
	<table border="1" style="width:100%">
    <thead>
    <th>ID</th>
    <th>Seller</th>
    <th>Sort</th>
    <th>Quantity</th>
    <th>Price</th>>
    </thead>
    <c:forEach items="${offersList}" var="offers">
        <tr>
            <td>${offers.ID}</td>
            <td>${offers.user.name}</td>
            <td>${offers.sort.name}</td>
            <td>${offers.quantity}</td>
            <td>${offers.price}</td>
        </tr>
    </c:forEach>

</table>
	
	<h3>Add offer</h3>
	<form action="Controller" name="OffersForm" method="post">
    <input type="hidden" name="command" value="addOrder"/>
    
    <input name="Input Sort" type="text"/><br/>
    
    <input name="Input Quantity" type="text"/><br/>
   
    <input type="submit" value="make an order">



</form>
</body>
</html>
