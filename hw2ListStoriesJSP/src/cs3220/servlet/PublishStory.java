package cs3220.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.ListStoryEntry;

@WebServlet("/PublishStory")
public class PublishStory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PublishStory() {
        super();
    }

    private ListStoryEntry getEntry(int id) {
		@SuppressWarnings("unchecked")
		List<ListStoryEntry> entries = (List<ListStoryEntry>) getServletContext().getAttribute("entries");

		for(ListStoryEntry entry : entries) {
			if(entry.getId() == id) return entry;
		}
		return null;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		
		ListStoryEntry entry = getEntry(Integer.parseInt(request.getParameter("id")));
		entry.setPublishDate(formatter.format(date).toString());
		response.sendRedirect("ListStory");

	}

}
