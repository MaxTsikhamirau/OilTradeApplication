<%@ include file="includePage.jsp" %>
<html>
<head>
<title>
<fmt:message key = "add.offer.page.title"/>
</title>

<body>
<h3><fmt:message key="add.offer.page.head" bundle="${one}"/></h3>
	
	<form action="Controller"  method="post">
    <input type="hidden" name="command" value="saveOffer"/>
    <fieldset>
   <legend>
  <fmt:message key="add.offer.page.legend" bundle="${one}"/>
   </legend>
   
    <select name="sort" size="1" multiple="multiple">
<option value="WTI"><fmt:message key="add.offer.page.wti" bundle="${one}"/></option>
<option value="Brent"><fmt:message key="add.offer.page.brent" bundle="${one}"/></option>
<option value="Siberia Light"><fmt:message key="add.offer.page.siberia.light" bundle="${one}"/></option>
<option value="Ambient Black"><fmt:message key="add.offer.page.ambient.black" bundle="${one}"/></option>
<option value="Libean Light"><fmt:message key="add.offer.page.libean.light" bundle="${one}"/></option>
<option value="Arabian extra"><fmt:message key="add.offer.page.arabian.extra" bundle="${one}"/></option>
<option value="American Black"><fmt:message key="add.offer.page.american.black" bundle="${one}"/></option>

</select>
	  <br/>
    <fmt:message key="add.offer.page.quantity" bundle="${one}"/> 
    <input name="quantity" type="number" size="20"/><br/>
   <fmt:message key="add.offer.page.price" bundle="${one}"/> 
   <input name="price" type="number" size="20"/><br/>
   
     
    <fmt:message var="addOffer" key="add.offer.page.button" bundle="${one}" />
		<input type="submit" value="${addOffer}"> 
    
 </fieldset>
</form>
</body>
</html>
