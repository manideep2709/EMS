package com.mani.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mani.employee.Employee;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
					"manideepannamaneni", "Venkat@9");
			Statement stmt = con.createStatement();

			System.out.println(con);
			String usr_name = request.getParameter("usr_name");
			String usr_pass = request.getParameter("usr_pass");

			PreparedStatement ps = con
					.prepareStatement("select usr_name from employee where usr_name=? and usr_pass=?");
			ps.setString(1, usr_name);
			ps.setString(2, usr_pass);

			ResultSet result = ps.executeQuery();

			if (result.next()) {

				ResultSet rs = stmt.executeQuery("select * from employee");

				List<Employee> employeeList = new ArrayList<Employee>();

				while (rs.next()) {

					Employee emp = new Employee();
					emp.setEmp_id(rs.getInt("emp_id"));
					emp.setUsr_name(rs.getString("usr_name"));
					emp.setUsr_pass(rs.getString("usr_pass"));
					emp.setAddress(rs.getString("address"));
					employeeList.add(emp);

				}
				request.getSession().setAttribute("employeeList", employeeList);

				request.getRequestDispatcher("displayEmp.jsp").forward(request, response);

				//rd.forward(request, response);

			} else {
				PrintWriter out = response.getWriter();
				out.println("<h1>Invalid Credentials!!!!!</h1>");
				out.println("<a href = login.jsp>Try Again!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
