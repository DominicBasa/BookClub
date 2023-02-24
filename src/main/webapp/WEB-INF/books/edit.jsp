<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Dashboard</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/main.css" />
		<!-- change to match your file/naming structure -->
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/js/app.js"></script>
		<!-- change to match your file/naming structure -->
    <!-- BOOTSWATCH CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/slate/bootstrap.min.css" integrity="sha384-8iuq0iaMHpnH2vSyvZMSIqQuUnQA7QM+f6srIdlgBrTSEyd//AWNMyEaSF2yPzNQ" crossorigin="anonymous">
	</head>
	<body>
		<div class="container mt-2" >
			<div class="col card border-dark p-4">
        <h1>Add a Book</h1>
        <form:form action="/books/${book.id}" method="post" modelAttribute="book">
            <input type="hidden" name="_method" value="put">
            <form:hidden path="user" value="${userId}"></form:hidden>
          <div class="form-control">
            <form:label path="title">Title</form:label>
            <form:errors path="title" />
            <form:input path="title" />
          </div>
          <div class="form-control">
            <form:label path="author">Author</form:label>
            <form:errors path="author" />
            <form:input path="author" />
          </div>
          <div class="form-control">
            <form:label path="myThoughts">My Thoughts</form:label>
            <form:errors path="myThoughts" />
            <form:input path="myThoughts" />
          </div>
            <input type="submit" value="Edit Book">
        </form:form>
        <a href="/books">Back to shelves</a>
      </div>
    </div>
	</body>
</html>
