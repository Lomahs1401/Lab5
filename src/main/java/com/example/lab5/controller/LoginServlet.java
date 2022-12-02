package com.example.lab5.controller;

import com.example.lab5.service.LoginService;
import com.example.lab5.service.impl.LoginServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        this.loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/account/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if (loginService.isExistAccount(username, password)) {
            session.setAttribute("username", username);
            session.setAttribute("password", username);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            String msgError = "Đăng nhập thất bại. Vui lòng thử lại";
            session.setAttribute("status_error", msgError);
            request.getRequestDispatcher("view/account/login.jsp").forward(request, response);
        }
    }
}
