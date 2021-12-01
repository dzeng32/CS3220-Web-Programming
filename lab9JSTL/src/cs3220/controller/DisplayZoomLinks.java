package cs3220.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Link;
import cs3220.model.Course;

@WebServlet("/DisplayZoomLinks")
public class DisplayZoomLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayZoomLinks() {
        super();
    }

    private Course getEntry(int id) {
		@SuppressWarnings("unchecked")
		List<Course> entries = (List<Course>) getServletContext().getAttribute("courseEntries");

		for(Course entry : entries) {
			if(entry.getId() == id) return entry;
		}
		return null;
	}
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
//		List<CourseInfo> courseInfoEntries = new ArrayList<CourseInfo>();
//		courseInfoEntries.add(new CourseInfo("Lecture", "https://calstatela.zoom.us/j/12345"));
//		courseInfoEntries.add(new CourseInfo("Lab", "https://calstatela.zoom.us/j/12346"));
        
		List<Course> courseEntries = new ArrayList<Course>();
		Course course = new Course("CS3220");
		course.getLinks().add(new Link("Lecture", "https://calstatela.zoom.us/j/12345"));
		course.getLinks().add(new Link("Lab", "https://calstatela.zoom.us/j/12346"));
		
//		List<CourseInfo> courseInfoEntries = course.getCourseList();
//		courseInfoEntries.add(new CourseInfo("Lecture", "https://calstatela.zoom.us/j/12345"));
//		courseInfoEntries.add(new CourseInfo("Lab", "https://calstatela.zoom.us/j/12346"));
		
		courseEntries.add(course);
		
		Course course2 = new Course("CSTest");
		course2.getLinks().add(new Link("Lecture2", "https://calstatela.zoom.us/j/2222"));
		course2.getLinks().add(new Link("Lab2", "https://calstatela.zoom.us/j/2223"));

		courseEntries.add(course2);
		
//        getServletContext().setAttribute( "classInfoEntries", courseInfoEntries );
        getServletContext().setAttribute("courseEntries", courseEntries);
        getServletContext().setAttribute("selectedCourse", course);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/DisplayZoomLink.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("courseId"));
		List<Course> courses = (List<Course>) getServletContext().getAttribute("courseEntries");
		
		for(Course course : courses) {
			if(course.getId() == id) {
				getServletContext().setAttribute("selectedCourse", course);
				break;
			}
		}
		
		response.sendRedirect("DisplayZoomLinks");
	}

}
