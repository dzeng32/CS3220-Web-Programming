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


        getServletContext().setAttribute( "entries", entries );
	}

    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ListStoryEntry> entries = (List<ListStoryEntry>) getServletContext().getAttribute("entries");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Story List</title></head><body>");
		out.println("<a href='SubmitStory'>Submit Story </a>");
		
		out.println("<table border ='1'>");
		out.println("<tr>");
		out.println("<th> Story </th>");
		out.println("<th> Submitted </th>");
		out.println("<th> Published </th>");
		out.println("<th> Operations </th>");
		out.println("<tr>");
		
		for(ListStoryEntry entry : entries) {
			out.println("<tr>");
			out.println("<td><a href='DisplayStory?id=" + entry.getId() + "'>" + entry.getStoryTitle() +"</a></td>");
			out.println("<td>" + entry.getSubmitDate() +"</td>");
			//add if else for publish date if null then a href publish dat link, otherwise bottom
			if(entry.getPublishDate() == null) 
				out.println("<td><a href='PublishStory?id=" + entry.getId() + "'>Publish</a></td>");
			else
				out.println("<td>" + entry.getPublishDate() +"</td>");
			
			out.println("<td><a href='EditStory?id=" + entry.getId() + "'>Edit </a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
	}

}
