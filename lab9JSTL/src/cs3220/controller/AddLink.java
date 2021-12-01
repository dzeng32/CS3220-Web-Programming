package cs3220.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Course;
import cs3220.model.Link;

@WebServlet("/AddLink")
public class AddLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddLink() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sectionTitle = request.getParameter("sectionTitle");
		String zoom = request.getParameter("zoom");
		Course course = (Course) getServletContext().getAttribute("selectedCourse");

		course.getLinks().add( new Link(sectionTitle, zoom));
		
		response.sendRedirect("DisplayZoomLinks");
	}

}
