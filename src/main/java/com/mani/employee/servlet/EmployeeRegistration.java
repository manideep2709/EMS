package com.mani.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeRegistration
 */
@WebServlet("/add")
public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement stmt;

	public void init() {

		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "manideepannamaneni",
					"Venkat@9");
			System.out.println(connection);
			stmt = connection.prepareStatement("INSERT INTO employee (usr_name, usr_pass, address) 	values ( ?, ?, ?)");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usr_name = request.getParameter("usr_name");

		String usr_pass = request.getParameter("usr_pass");

		String address = request.getParameter("address");

		try {
			stmt.setString(1, usr_name);
			stmt.setString(2, usr_pass);
			stmt.setString(3, address);

			int result = stmt.executeUpdate();

			PrintWriter out = response.getWriter();

			if (result > 0) {

				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				rd.forward(request, response);
		
			} else {
				out.print("<b> employee registration NOT done <b>");

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void destroy() {

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
