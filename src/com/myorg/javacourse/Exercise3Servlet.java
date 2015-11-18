package com.myorg.javacourse;

import java.io.IOException;
import javax.servlet.http.*;
import com.myorg.javacourse.MathManager;

@SuppressWarnings("serial")
public class Exercise3Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		MathManager mathManager = new MathManager(50.0,30.0,50.0,20.0,30.0);
		String resultStr = MathManager.getResults();
		
	    resp.getWriter().println(resultStr);

	}
}

