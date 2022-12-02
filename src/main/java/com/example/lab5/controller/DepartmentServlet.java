package com.example.lab5.controller;

import com.example.lab5.model.Department;
import com.example.lab5.model.Employee;
import com.example.lab5.service.DepartmentService;
import com.example.lab5.service.impl.DepartmentServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/department")
public class DepartmentServlet extends HttpServlet {

    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        departmentService = new DepartmentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                showListPage(request, response);
                break;
            case "create":
                showCreatePage(request, response);
                break;
            case "update":
                showUpdatePage(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                handleCreate(request, response);
                break;
            case "update":
                handleUpdate(request, response);
                break;
        }
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = departmentService.getAllDepartments();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("view/department/list.jsp").forward(request, response);
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/department/create.jsp").forward(request, response);
    }

    private void handleCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String room = request.getParameter("room");
        String name = request.getParameter("name");
        Department newDepartment = new Department(id, room, name);

        boolean result = departmentService.createDepartment(newDepartment);

        HttpSession session = request.getSession();

        if (result) {
            List<Department> departments = departmentService.getAllDepartments();
            request.setAttribute("departments", departments);
            String msgSuccess = "Thêm phòng ban mới thành công";
            session.setAttribute("status_success", msgSuccess);
            request.getRequestDispatcher("view/department/list.jsp").forward(request, response);
        } else {
            String msgError = "Thêm thất bại. Vui lòng thử lại";
            session.setAttribute("status_error", msgError);
            request.getRequestDispatcher("view/department/create.jsp").forward(request, response);
        }
    }

    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Department department = departmentService.getDepartmentById(id);
        request.setAttribute("department", department);
        request.getRequestDispatcher("view/department/update.jsp").forward(request, response);
    }

    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String room = request.getParameter("room");
        String name = request.getParameter("name");
        Department updateDepartment = new Department(id, room, name);

        boolean result = departmentService.updateDepartment(updateDepartment);

        HttpSession session = request.getSession();

        if (result) {
            List<Department> departments = departmentService.getAllDepartments();
            request.setAttribute("departments", departments);
            String msgSuccess = "Cập nhật thành công";
            session.setAttribute("status_success", msgSuccess);
            request.getRequestDispatcher("view/department/list.jsp").forward(request, response);
        } else {
            String msgError = "Cập nhật thất bại. Vui lòng thử lại";
            session.setAttribute("status_error", msgError);
            request.getRequestDispatcher("view/department/update.jsp").forward(request, response);
        }
    }
}
