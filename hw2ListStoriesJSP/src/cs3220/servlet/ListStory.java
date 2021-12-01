package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.ListStoryEntry;

@WebServlet(urlPatterns = "/ListStory", loadOnStartup = 1)
public class ListStory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListStory() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<ListStoryEntry> entries = new ArrayList<ListStoryEntry>();
		
		//initial testing info to look similar to example
		entries.add(new ListStoryEntry("Apple Watch Series 6 Review", "Apple newest generation", "Story content 1"));
		entries.add(new ListStoryEntry("Battle of the $350 laptops", "Two laptops which is better", "Story content 2"));
		entries.add(new ListStoryEntry("Google Maps gets a COVID-19 layer", "Google maps updated for covid", "Story content 3"));

		entries.get(0).setSubmitDate("09/27/2020");
		entries.get(1).setSubmitDate("09/25/2020");
		entries.get(1).setPublishDate("09/27/2020");
		entries.get(2).setSubmitDate("09/23/2020");
		entries.get(2).setPublishDate("09/24/2020");

		//saved in application scope so servlets and jsps
        getServletContext().setAttribute( "entries", entries );
	}

    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/ListStory.jsp").forward(request, response);

	}

}
