<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <style>
        .center {
            display: flex;
            text-align: center;
            justify-content: space-around;
            margin-top: 32px;
        }
        a {
            margin-top: 8px;
            margin-bottom: 8px;
            font-size: 16px;
            display: block;
            width: 220px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center">
    <div>
        <h1 style="text-align: center; color: white; margin-top: 8px;">Quản lý nhân viên và phòng ban theo mô hình Servlet MVC</h1>
    </div>
    <c:choose>
        <c:when test="${sessionScope['username'] != null && sessionScope['password'] != null}">
            <h4 style="text-align: center; color: white; margin: 8px 0 8px 40px;">
                <c:out value="Xin chào ${sessionScope['username']}"/>
            </h4>
            <div style="margin-left: 40px;">
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-success" style="width: 140px;">Đăng xuất</a>
            </div>
        </c:when>
        <c:otherwise>
            <div style="margin-left: 40px;">
                <a href="${pageContext.request.contextPath}/login" class="btn btn-success" style="width: 140px;">Đăng nhập</a>
            </div>
        </c:otherwise>
    </c:choose>
</nav>
<div class="container">
    <div class="center">
        <div class="employee_management">
            <img src="Img/employee.jpg" alt="Staff Image" width="500px" height="300px">
            <h1 style="margin-top: 16px;">Quản lý nhân viên</h1>
            <h3><a href="${pageContext.request.contextPath}/employee?action=list" class="btn btn-secondary">Xem danh sách nhân viên</a></h3>
            <c:if test="${sessionScope['username'] != null && sessionScope['password'] != null}">
                <h3><a href="${pageContext.request.contextPath}/employee?action=create" class="btn btn-primary">Thêm mới nhân viên</a></h3>
            </c:if>
        </div>
        <div class="department_management">
            <img src="Img/department.png" alt="Staff Image" width="500px" height="300px">
            <h1 style="margin-top: 16px;">Quản lý phòng ban</h1>
            <h3><a href="${pageContext.request.contextPath}/department?action=list" class="btn btn-secondary">Xem danh sách phòng ban</a></h3>
            <c:if test="${sessionScope['username'] != null && sessionScope['password'] != null}">
                <h3><a href="${pageContext.request.contextPath}/department?action=create" class="btn btn-primary">Thêm mới phòng ban</a></h3>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>