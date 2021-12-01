package cs3220.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Department;
import cs3220.model.Faculty;
import cs3220.service.DbService;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddFaculty() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DbService dbService = new DbService();
        request.setAttribute( "departments", dbService.getDepartments() );
        dbService.close();
        request.getRequestDispatcher("/WEB-INF/AddFaculty.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departmentName = request.getParameter("department");
		Faculty faculty = new Faculty(request.getParameter("faculty"));
		if (request.getParameter("chair") != null)
			faculty.setChair(true);

		DbService dbService = new DbService();
        dbService.addFaculty( departmentName, faculty.getName(), faculty.isChair() );
        dbService.close();
		

		response.sendRedirect("DisplayFaculty");
	}

}
