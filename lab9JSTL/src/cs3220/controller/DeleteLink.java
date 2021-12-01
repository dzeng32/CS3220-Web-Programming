package cs3220.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Course;
import cs3220.model.Link;

@WebServlet("/DeleteLink")
public class DeleteLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteLink() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int linkId = Integer.parseInt(request.getParameter("linkId"));
		Course course = (Course) getServletContext().getAttribute("selectedCourse");
		
		int index = 0;
		for(Link link : course.getLinks()) {
			if(link.getId() == linkId) {
				break;
			}
			index++;
		}
		course.getLinks().remove(index);
		request.getRequestDispatcher("/WEB-INF/DisplayZoomLink.jsp").forward(request, response);

	}


}
