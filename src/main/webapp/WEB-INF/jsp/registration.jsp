<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title> Registration Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <meta charset="utf-8">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: Green">
        <div>
            <a class="navbar-brand"> CRUD App </a>
        </div>
        <div>
            <a class="navbar-brand"> Registration Page </a>
            <jsp:include page="menu.jsp"></jsp:include>
        </div>

    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form:form method="post">
                <caption>
                    <h2>
                        Add New User
                    </h2>
                </caption>


                <fieldset class="form-group">
                    <label>User Login</label> <input type="text" value="<c:out value="" />" class="form-control" name="username">
                </fieldset>

                <fieldset class="form-group">
                    <label>User Password</label> <input type="text" value="<c:out value="" />" class="form-control" name="password">
                </fieldset>


                <fieldset class="form-group">
                    <label>User Email</label> <input type="text" value="<c:out value="" />" class="form-control" name="email">
                </fieldset>

                <fieldset class="form-group">
                    <label>User PhoneNumber</label> <input type="text" value="<c:out value="" />" class="form-control" name="phoneNumber">
                </fieldset>

                <fieldset class="form-group">
                    <label>User BirthDate</label> <input type="date" value="<c:out value="" />" class="form-control" name="birthDate">
                </fieldset>

                <button type="submit" class="btn btn-success" formaction="${pageContext.request.contextPath}/registration/user">Save</button>
            </form:form>
        </div>
    </div>
</div>
</body>

</html>