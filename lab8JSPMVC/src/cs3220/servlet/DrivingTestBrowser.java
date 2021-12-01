package cs3220.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Question;

@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DrivingTestBrowser() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String fileLocation = getServletContext().getRealPath("/WEB-INF/DrivingTest.txt");		 
		List<Question> questions = new ArrayList<Question>();

		try {
			Scanner in = new Scanner(new File(fileLocation));
			
			while( in.hasNextLine() ) {
	            Question drivingQuestions = new Question();
	            drivingQuestions.setDescription(in.nextLine());
	            drivingQuestions.setAnswerA(in.nextLine());
	            drivingQuestions.setAnswerB(in.nextLine());
	            drivingQuestions.setAnswerC(in.nextLine());
	            drivingQuestions.setCorrectAnswer(Integer.parseInt(in.nextLine()));
	            in.nextLine(); //Skip the blank line.
	            questions.add(drivingQuestions);
	        }
	        in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		getServletContext().setAttribute("questions", questions);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Question> questions = (List<Question>) getServletContext().getAttribute("questions");
		
		//int index = Integer.parseInt(request.getParameter("index"));
		int index;
		if(request.getParameter("index") == null) {
			index = 0;
			request.getSession().setAttribute("index", 0);
		}else {
			index = Integer.parseInt(request.getParameter("index"));
			request.getSession().getAttribute("index");
		}
		
		if(index < questions.size()) {
			request.getSession().setAttribute("index", index);
		}else {
			request.getSession().setAttribute("index", 0);
		}
		
		request.getRequestDispatcher("/WEB-INF/Display.jsp?index=" + request.getSession().getAttribute("index")).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
