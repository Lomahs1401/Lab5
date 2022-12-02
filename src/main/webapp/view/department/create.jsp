<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehoanglong
  Date: 02/12/2022
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới phòng ban</title>
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
        }
        .controls {
            display: flex;
            justify-content: center;
        }
        .controls > * {
            margin: 0 4px;
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
        <div class="center">
            <h1 style="text-align: center; margin-top: 100px;">Thêm mới phòng ban</h1>
            <form action="${pageContext.request.contextPath}/department?action=create" method="POST"
                  name="create_department_form" class="mt-16 needs-validation" novalidate>
                <c:if test="${sessionScope['status_error'] != null}">
                    <div class="alert alert-danger alert-dismissible show-message" style="margin: 16px 3.5%;">
                        <button class="close" data-dismiss="alert" aria-label="close">&times;</button>
                        <strong>
                            <c:out value="${sessionScope['status_error']}"/>
                            <c:remove var="status_error"/>
                        </strong>
                    </div>
                </c:if>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="id">ID:</label>
                            <input type="text" class="form-control" placeholder="Nhập ID" id="id" name="id" required>
                            <div class="valid-feedback">Hợp lệ</div>
                            <div class="invalid-feedback">Trường này không được để trống</div>
                        </div>
                        <div class="form-group">
                            <label for="room">Phòng:</label>
                            <input type="text" class="form-control" placeholder="Nhập phòng" id="room" name="room" required>
                            <div class="valid-feedback">Hợp lệ</div>
                            <div class="invalid-feedback">Trường này không được để trống</div>
                        </div>
                        <div class="form-group">
                            <label for="name">Tên phòng ban:</label>
                            <input type="text" class="form-control" placeholder="Nhập tên phòng ban" id="name" name="name" required>
                            <div class="valid-feedback">Hợp lệ</div>
                            <div class="invalid-feedback">Trường này không được để trống</div>
                        </div>
                    </div>
                </div>
                <div class="controls">
                    <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Home page</a>
                    <button type="reset" class="btn btn-secondary">Hủy</button>
                    <button type="submit" class="btn btn-success" style="margin-right: 8px">Xác nhận</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        (() => {
            'use strict';
            window.addEventListener('load', function() {
                // Get the forms we want to add validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
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
