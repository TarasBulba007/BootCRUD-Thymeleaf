<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>My First CRUD Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: Green">
        <div>
            <a class="navbar-brand"> CRUD App </a>
        </div>
        <div>
            <a class="navbar-brand"> My First CRUD APP </a>
            <jsp:include page="menu.jsp"></jsp:include>
        </div>

    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${user != null}">
            <form action="/admin/edit_user/user" method="post">
                </c:if>
                <c:if test="${user == null}">
                <form action="/admin/edit_user/user" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${user == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>User Login</label> <input type="text" value="<c:out value='${user.username}' />" class="form-control" name="username">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User Password</label> <input type="text" value="<c:out value='${user.password}' />" class="form-control" name="password">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User Email</label> <input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User PhoneNumber</label> <input type="text" value="<c:out value='${user.phoneNumber}' />" class="form-control" name="phoneNumber">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User BirthDate</label> <input type="date" value="<c:out value='${user.birthDate}' />" class="form-control" name="birthDate">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>