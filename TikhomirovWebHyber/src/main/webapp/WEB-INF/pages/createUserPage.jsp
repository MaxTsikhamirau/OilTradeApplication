<%@ include file="includePage.jsp" %>
<html>
<head>
<title>
<fmt:message key = "create.user.page.title"/>
</title>

<body>
<h3><fmt:message key="create.user.page.head" bundle="${one}"/></h3>
	
	<form action="Controller"  method="post">
    <input type="hidden" name="command" value="CreateUser"/>
    
	  
    <fmt:message key="create.user.page.name" bundle="${one}"/> <input name="name" type="text"/><br/>
    <fmt:message key="create.user.page.login" bundle="${one}"/>  <input name="login" type="text"/><br/>
   <fmt:message key="create.user.page.password" bundle="${one}"/>  <input name="password" type="password"/><br/>
    <fmt:message key="create.user.page.city" bundle="${one}"/>  <input name="city" type="text"/><br/>
   <fmt:message key="create.user.page.country" bundle="${one}"/>   <input name="country" type="text"/><br/>
     <fmt:message key="create.user.page.telephone" bundle="${one}"/>   <input name="telephone" type="text"/><br/>
     
    <fmt:message var="createUser" key="create.user.page.button" bundle="${one}" />
		<input type="submit" value="${createUser}"> 
    

</form>
</body>
</html>
