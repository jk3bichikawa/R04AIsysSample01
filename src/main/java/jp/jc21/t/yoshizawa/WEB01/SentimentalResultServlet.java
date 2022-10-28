package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bunseki")
public class SentimentalResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SentimentalResultServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("string");
		request.setAttribute("string", string);

		try {
			Senti result = Sentiment.getSentiment(string);
			double negative = result.documents[0].confidenceScores.negative;
			request.setAttribute("negative", negative);
			double neutral = result.documents[0].confidenceScores.neutral;
			request.setAttribute("neutral", neutral);
			double positive = result.documents[0].confidenceScores.positive;
			request.setAttribute("positive", positive);
			request.getRequestDispatcher("/WEB-INF/jsp/bunseki.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}