<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My First CRUD Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: Green">
        <div>
            <a class="navbar-brand"> My First CRUD APP </a>
            <jsp:include page="menu.jsp"></jsp:include>
        </div>
    </nav>
</header>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Users</h3>
        <hr>

        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Email</th>
                <th>Phone</th>
                <th>BirthDate</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>


            <c:forEach var="user" items="${list}">

                <tr>
                    <td>
                        <c:out value="${user.id}"/>
                    </td>
                    <td>
                        <c:out value="${user.username}"/>
                    </td>
                    <td>
                        <c:out value="${user.email}"/>
                    </td>
                    <td>
                        <c:out value="${user.phoneNumber}"/>
                    </td>
                    <td>
                        <c:out value="${user.birthDate}"/>
                    </td>
                    <td>
                        <a href="/admin/edit_user?id=<c:out value='${user.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/admin/delete?id=<c:out value='${user.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

        <div class="container text-right">
            <a href="<%=request.getContextPath()%>/registration" class="btn btn-success">Create
                New User</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/admin/deleteAll" class="btn btn-success">Delete
                All Users</a>
        </div>
    </div>
</div>
</body>

</html>