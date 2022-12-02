package com.example.lab5.controller;

import com.example.lab5.service.RegisterService;
import com.example.lab5.service.impl.RegisterServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    private RegisterService registerService;

    @Override
    public void init() throws ServletException {
        registerService = new RegisterServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/account/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if (registerService.createNewAccount(username, password)) {
            String msgSuccess = "Đăng ký thành công";
            session.setAttribute("status_success", msgSuccess);
            request.getRequestDispatcher("view/account/login.jsp").forward(request, response);
        } else {
            String msgError = "Đăng ký thất bại. Vui lòng thử lại";
            session.setAttribute("status_error", msgError);
            request.getRequestDispatcher("view/account/register.jsp").forward(request, response);
        }
    }
}
