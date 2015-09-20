<%@ include file="includePage.jsp" %>
<html>
<head>
<title>
<fmt:message key = "add.order.page.title"/>
</title>

<body>
<h3><fmt:message key="add.order.page.head" bundle="${one}"/></h3>
	
	<form action="Controller"  method="post">
    <input type="hidden" name="command" value="saveOrder"/>
    <fieldset>
   <legend>
  <fmt:message key="add.order.page.legend" bundle="${one}"/>
   </legend>
   
    <select name="sort" size="1" multiple="multiple">
<option value="WTI"><fmt:message key="add.order.page.wti" bundle="${one}"/></option>
<option value="Brent"><fmt:message key="add.order.page.brent" bundle="${one}"/></option>
<option value="Siberia Light"><fmt:message key="add.order.page.siberia.light" bundle="${one}"/></option>
<option value="Ambient Black"><fmt:message key="add.order.page.ambient.black" bundle="${one}"/></option>
<option value="Libean Light"><fmt:message key="add.order.page.libean.light" bundle="${one}"/></option>
<option value="Arabian extra"><fmt:message key="add.order.page.arabian.extra" bundle="${one}"/></option>
<option value="American Black"><fmt:message key="add.order.page.american.black" bundle="${one}"/></option>

</select>
	  <br/>
    <fmt:message key="add.order.page.quantity" bundle="${one}"/> 
    <input name="quantity" type="number" size="20"/><br/>
   <fmt:message key="add.order.page.price" bundle="${one}"/> 
   <input name="price" type="number" size="20"/><br/>
   
     
    <fmt:message var="addOrder" key="add.order.page.button" bundle="${one}" />
		<input type="submit" value="${addOrder}"> 
    
 </fieldset>
</form>
</body>
</html>
