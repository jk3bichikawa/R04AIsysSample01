package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/languageRequest")
public class SentimentRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SentimentRequest() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Sentiment.jsp").forward(request, response);
	}

}