<%@ include file="includePage.jsp"%>
<html>
<head>
<title><fmt:message key="orders.list.page.title" bundle="${one}" />
</title>
</head>

<body>
	<h3>
		<fmt:message key="orders.list.page.head" bundle="${one}" />
				</h3>

	<table border="1" style="width: 80%">
		<thead>
			<th>ID</th>
			<th>Traider</th>
			<th>Sort</th>
			<th>Quantity</th>
			<th>Price</th>
		</thead>
		<c:forEach items="${ordersList}" var="orders">
			<tr>
				<td>${orders.order_id}</td>
				 <td>${orders.userVO.user_name}</td>
				<td>${orders.sortVO.sort_name}</td>
				<td>${orders.quantity}</td>
				<td>${orders.price}</td>
			</tr>
		</c:forEach>
	</table>


	
</body>
</html>
