<%@ include file="includePage.jsp"%>
<html>
<head>
<title><fmt:message key="offers.list.page.title" bundle="${one}" />
</title>
</head>

<body>
	<h3>
		<fmt:message key="offers.list.page.head" bundle="${one}" />  
		
		
	</h3>
		<table border="1" style="width: 80%">
		<thead>
			<th>ID</th>
			<th>Traider</th>
			<th>Sort</th>
			<th>Quantity</th>
			<th>Price</th>
		</thead>
		<c:forEach items="${offersList}" var="offers">
			<tr>
				<td>${offers.offer_id}</td>
				 <td>${offers.userVO.user_name}</td>
				<td>${offers.sortVO.sort_name}</td>
				<td>${offers.quantity}</td>
				<td>${offers.price}</td>
			</tr>
		</c:forEach>
	</table>


	
</body>
</html>
