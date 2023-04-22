/*package com.mani.employee.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mani.employee.Employee;

@WebServlet("/empdisplay")
public class EmployeeDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public void init() {

		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "manideepannamaneni",
					"Venkat@9");
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Statement stmt = connection.createStatement();

			ResultSet result = stmt.executeQuery("select * from employee");

			List<Employee> employeeList = new ArrayList<Employee>();

			while (result.next()) {

				Employee emp = new Employee();
				emp.setEmp_id(result.getInt("emp_id"));
				emp.setUsr_name(result.getString("usr_name"));
				emp.setUsr_pass(result.getString("usr_pass"));
				emp.setAddress(result.getString("address"));
				employeeList.add(emp);

			}
			request.setAttribute("employeeList", employeeList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("displayEmp.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void destroy() {

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}*/
