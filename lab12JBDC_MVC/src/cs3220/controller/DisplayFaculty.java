package cs3220.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Department;
import cs3220.model.Faculty;
import cs3220.service.DbService;

@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DisplayFaculty() {
		super();
	}

	//comment this out, not needed for sql database
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//
//		List<Department> departments = new ArrayList<Department>();
//		departments.add(new Department("Computer Science"));
//		departments.add(new Department("Electrical and Computer Engineering"));
//		getServletContext().setAttribute("departments", departments);
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get data from database
		
		DbService dbService = new DbService();
        request.setAttribute( "departments", dbService.getDepartments() );
        dbService.close();
		request.getRequestDispatcher("/WEB-INF/DisplayFaculty.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
