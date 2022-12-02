<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehoanglong
  Date: 01/12/2022
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa nhân viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <style>
        .container {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .center {
            margin: 0 auto;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="center">
            <form action="${pageContext.request.contextPath}/employee?action=delete&&id=${employee.getId()}" method="POST">
                <div class="card" style="width: 440px;">
                    <div class="card-header bg-danger">
                        <h1 style="margin-top: 16px; color: white;">Xóa nhân viên</h1>
                    </div>
                    <img class="card-img-top" src="${employee.getImage()}" alt="Card image">
                    <div class="card-body">
                        <h4>
                            Mã số nhân viên: <c:out value="${employee.getId()}"/>
                        </h4>
                        <h4>
                            Họ và tên: <c:out value="${employee.getName()}"/>
                        </h4>
                        <h4>
                            Email: <c:out value="${employee.getEmail()}"/>
                        </h4>
                        <h4>
                            SĐT: <c:out value="${employee.getPhone()}"/>
                        </h4>
                        <h4>
                            Địa chỉ: <c:out value="${employee.getAddress()}"/>
                        </h4>
                        <h4>
                            Thuộc phòng ban: <c:out value="${departmentName}"/>
                        </h4>
                    </div>
                    <div class="card-footer">
                        <a href="${pageContext.request.contextPath}/employee?action=list" class="btn btn-primary">Back</a>
                        <button class="btn btn-danger" type="submit">Xác nhận xóa</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
