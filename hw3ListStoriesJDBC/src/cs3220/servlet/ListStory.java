package cs3220.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cs3220.service.DbServiceListStory;

@WebServlet(urlPatterns = "/ListStory", loadOnStartup = 1)
public class ListStory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListStory() {
		super();
	}

    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    	DbServiceListStory dbService = new DbServiceListStory();
        request.setAttribute( "entries", dbService.getEntries() );
        dbService.close();
        
		request.getRequestDispatcher("/WEB-INF/ListStory.jsp").forward(request, response);

	}

}
