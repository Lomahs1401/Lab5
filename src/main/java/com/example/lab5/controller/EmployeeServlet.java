package com.example.lab5.controller;

import com.example.lab5.model.Department;
import com.example.lab5.model.Employee;
import com.example.lab5.service.DepartmentService;
import com.example.lab5.service.EmployeeService;
import com.example.lab5.service.impl.DepartmentServiceImpl;
import com.example.lab5.service.impl.EmployeeServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
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
            case "delete":
                showDeletePage(request, response);
                break;
            case "detail":
                showDetailPage(request, response);
                break;
            case "search":
                showSearchPage(request, response);
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
            case "delete":
                handleDelete(request, response);
                break;
        }
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        List<String> departmentsName = new ArrayList<>();
        for (Employee employee : employees) {
            String name = departmentService.getDepartmentNameById(employee.getDepartmentId());
            departmentsName.add(name);
        }
        request.setAttribute("employees", employees);
        request.setAttribute("departments", departmentsName);
        request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = departmentService.getAllDepartments();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
    }

    private void handleCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String image = request.getParameter("image");
        int departmentId = Integer.parseInt(request.getParameter("department_id"));
        Employee newEmployee = new Employee(id, name, email, phone, address, departmentId, image);

        boolean result = employeeService.createEmployee(newEmployee);

        HttpSession session = request.getSession();

        if (result) {
            List<String> departmentsName = new ArrayList<>();
            List<Employee> employees = employeeService.getAllEmployees();
            for (Employee employee : employees) {
                String departmentName = departmentService.getDepartmentNameById(employee.getDepartmentId());
                departmentsName.add(departmentName);
            }

            request.setAttribute("employees", employees);
            request.setAttribute("departments", departmentsName);

            String msgSuccess = "Thêm nhân viên mới thành công";
            session.setAttribute("status_success", msgSuccess);
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } else {
            List<Department> departments = departmentService.getAllDepartments();
            String msgError = "Thêm thất bại. Vui lòng thử lại";
            session.setAttribute("status_error", msgError);
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        }
    }

    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee employee = employeeService.getEmployeeById(id);
        List<Department> departments = departmentService.getAllDepartments();
        String departmentName = departmentService.getDepartmentNameById(employee.getDepartmentId());
        request.setAttribute("employee", employee);
        request.setAttribute("departments", departments);
        request.setAttribute("departmentName", departmentName);
        request.getRequestDispatcher("view/employee/update.jsp").forward(request, response);
    }

    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String image = request.getParameter("image");
        int departmentId = Integer.parseInt(request.getParameter("department_id"));
        Employee updateEmployee = new Employee(id, name, email, phone, address, departmentId, image);

        boolean result = employeeService.updateEmployee(updateEmployee);


        HttpSession session = request.getSession();

        if (result) {
            List<Employee> employees = employeeService.getAllEmployees();
            List<String> departmentsName = new ArrayList<>();
            for (Employee employee : employees) {
                String departmentName = departmentService.getDepartmentNameById(employee.getDepartmentId());
                departmentsName.add(departmentName);
            }

            request.setAttribute("employees", employees);
            request.setAttribute("departments", departmentsName);

            String msgSuccess = "Cập nhật thành công";
            session.setAttribute("status_success", msgSuccess);
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } else {
            List<Department> departments = departmentService.getAllDepartments();
            String departmentName = departmentService.getDepartmentNameById(departmentId);
            String msgError = "Cập nhật thất bại. Vui lòng thử lại";
            session.setAttribute("status_error", msgError);
            request.setAttribute("departments", departments);
            request.setAttribute("departmentName", departmentName);
            request.getRequestDispatcher("view/employee/update.jsp").forward(request, response);
        }
    }

    private void showDeletePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee employee = employeeService.getEmployeeById(id);
        String departmentName = departmentService.getDepartmentNameById(employee.getDepartmentId());
        request.setAttribute("employee", employee);
        request.setAttribute("departmentName", departmentName);
        request.getRequestDispatcher("view/employee/delete.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean result = employeeService.deleteEmployeeById(id);

        List<String> departmentsName = new ArrayList<>();

        HttpSession session = request.getSession();

        if (result) {
            List<Employee> employees = employeeService.getAllEmployees();
            for (Employee employee : employees) {
                String departmentName = departmentService.getDepartmentNameById(employee.getDepartmentId());
                departmentsName.add(departmentName);
            }

            request.setAttribute("employees", employees);
            request.setAttribute("departments", departmentsName);

            String msgSuccess = "Xóa nhân viên thành công";
            session.setAttribute("status_success", msgSuccess);
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } else {
            String msgError = "Xóa thất bại. Vui lòng thử lại";
            session.setAttribute("status_error", msgError);
            request.getRequestDispatcher("view/employee/delete.jsp").forward(request, response);
        }
    }

    private void showDetailPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee employee = employeeService.getEmployeeById(id);
        String departmentName = departmentService.getDepartmentNameById(employee.getDepartmentId());
        request.setAttribute("employee", employee);
        request.setAttribute("departmentName", departmentName);
        request.getRequestDispatcher("view/employee/detail.jsp").forward(request, response);
    }

    private void showSearchPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/employee/search.jsp").forward(request, response);
    }
}
