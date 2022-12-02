<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehoanglong
  Date: 02/12/2022
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <style>
        .container {
            max-width: 560px;
            margin-top: 160px;
            background: antiquewhite;
            border: 1px solid darkkhaki;
            border-radius: 5px;
            box-shadow: 5px 10px 8px #888888;
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
    <div class="container">
        <h1 style="text-align: center; margin-top: 20px;">Đăng Nhập</h1>
        <c:if test="${sessionScope['status_success'] != null}">
            <div class="alert alert-success alert-dismissible show-message" style="margin: 16px 3.5%;">
                <button class="close" data-dismiss="alert" aria-label="close">&times;</button>
                <strong>
                    <c:out value="${sessionScope['status_success']}"/>
                    <c:remove var="status_success"/>
                </strong>
            </div>
        </c:if>
        <c:if test="${sessionScope['status_error'] != null}">
            <div class="alert alert-danger alert-dismissible show-message" style="margin: 16px 3.5%;">
                <button class="close" data-dismiss="alert" aria-label="close">&times;</button>
                <strong>
                    <c:out value="${sessionScope['status_error']}"/>
                    <c:remove var="status_error"/>
                </strong>
            </div>
        </c:if>
        <hr />
        <form action="${pageContext.request.contextPath}/login" method="POST"
              name="login_form" class="mt-16 needs-validation" novalidate>
            <!-- Username input -->
            <div class="form-outline mb-4">
                <label class="form-label" for="username">Username: </label>
                <input type="text" id="username" class="form-control" name="username" required/>
                <div class="valid-feedback">Hợp lệ</div>
                <div class="invalid-feedback">Trường này không được để trống</div>
            </div>

            <!-- Password input -->
            <div class="form-outline mb-4">
                <label class="form-label" for="password">Password: </label>
                <input type="password" id="password" class="form-control" name="password" required/>
                <div class="valid-feedback">Hợp lệ</div>
                <div class="invalid-feedback">Trường này không được để trống</div>
            </div>

            <!-- Submit button -->
            <button type="submit" class="btn btn-primary btn-block mb-4">
                <i class="fa-solid fa-right-to-bracket"></i>
                Đăng nhập
            </button>

            <!-- Register buttons -->
            <hr />
            <div class="text-center justify-content-center">
                <a href="${pageContext.request.contextPath}/">Home page</a>
                <p style="margin-top: 12px;">Chưa có tài khoản? <a href="${pageContext.request.contextPath}/view/account/register.jsp">Đăng ký tại đây!</a></p>
            </div>
        </form>
    </div>
    <script>
        (() => {
            'use strict';
            window.addEventListener('load', function() {
                // Get the forms we want to add validation styles to
                const forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                const validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
        $(document).ready(() => {
            setTimeout(() => {
                $('.close').click();
            }, 2200);
        });
    </script>
</body>
</html>
