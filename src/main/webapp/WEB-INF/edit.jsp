<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form:form action="/edit/${expense.id}" method="POST" modelAttribute="expense">
			<input type="hidden" name="_method" value="put" >
			<div>
				<form:label path="expenseName">Expense Name:</form:label>
				<form:errors path="expenseName" class="text-danger"/>
				<form:input type="text" path="expenseName" />
			</div>
			<div>
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" class="text-danger"/>
				<form:input type="text" path="vendor" />
			</div>
			<div>
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" class="text-danger"/>
				<form:input type="double" path="amount" />
			</div>
			<div>
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:textarea path="description" cols="30" rows="10"></form:textarea>
			</div>
			<button>Submit</button>
		</form:form>
		<a href="/expenses">Go Back</a>
	</div>

</body>
</html>