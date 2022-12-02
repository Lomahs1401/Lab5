<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehoanglong
  Date: 02/12/2022
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
        <style>
        #main {
        margin: 8px;
        }
        .center {
        text-align: center;
        }
        .mt-8 {
        margin-top: 8px;
        }
        .mt-16 {
        margin-top: 16px;
        }
        .mr-44 {
        margin-right: 44px;
        }
        #main > div {
        vertical-align: middle;
        text-align: center;
        }
        .controls {
        display: flex;
        justify-content: flex-start;
        }
        @keyframes fadeOut {
        from {
        opacity: 1;
        }
        to {
        opacity: 0;
        }
        }
        .show-message {
        animation: fadeOut 2.2s linear;
        }
    </style>
</head>
<body>
<div id="main">
    <div class="container">
        <h1 class="center mt-16">Danh sách phòng ban</h1>
        <c:if test="${sessionScope['status_success'] != null}">
            <div class="alert alert-success alert-dismissible show-message" style="margin: 16px 3.5%;">
                <button class="close" data-dismiss="alert" aria-label="close">&times;</button>
                <strong>
                    <c:out value="${sessionScope['status_success']}"/>
                    <c:remove var="status_success"/>
                </strong>
            </div>
        </c:if>
        <div class="container mt-16 table-responsive">
            <table class="table table-striped table-hover table-bordered">
                <thead class="thead-dark">
                    <tr class="center">
                        <th>ID</th>
                        <th>Phòng</th>
                        <th>Tên phòng ban</th>
                        <c:if test="${sessionScope['username'] != null && sessionScope['password'] != null}">
                            <th>
                                <i class="fa-solid fa-pen-to-square"></i>
                                Cập nhật
                            </th>
                        </c:if>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="department" items="${requestScope['departments']}">
                    <tr class="center">
                        <td>
                            <c:out value="${department.getId()}"/>
                        </td>
                        <td>
                            <c:out value="${department.getRoom()}"/>
                        </td>
                        <td>
                            <c:out value="${department.getName()}"/>
                        </td>
                        <c:if test="${sessionScope['username'] != null && sessionScope['password'] != null}">
                            <td>
                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/department?action=update&&id=${department.getId()}">Cập nhật</a>
                            </td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <?php endif; ?>
            <div class="controls">
                <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Home page</a>
            </div>
          </div>
    </div>
    <script>
        $(document).ready(() => {
            setTimeout(() => {
                $('.close').click();
            }, 2200);
        });
    </script>
</div>
</body>
</html>
