package kadai20add;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// セッションオブジェクトを取得
		HttpSession session = request.getSession(false);
		// Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		@SuppressWarnings("unchecked")
		List<String> text = (List<String>) session.getAttribute("CONTENT");
		
		if (text == null) {
			return;
		}

		out.println("<html><head><title>掲示板</title></head><body>");
		out.println("<form action=\"http://localhost:8080/jmaster/BbsServlet2?action=write\" method=\"POST\">");
		out.println("名前：");
		out.println("<div>");
		out.println("<input type=\"text\" name = \"NAME\">");
		out.println("</div>");
		out.println("メッセージ：<br>");
		out.println("<div>");
		out.println("<textarea name = \"TEXT\" rows=\"5\" cols=\"40\"></textarea>");
		out.println("</div>");
		out.println("<div>");
		out.println("<input type=\"submit\" value=\"書き込み\">");
		out.println("</div>");
		out.println("</form>");
		out.println("<hr>");
		int i = 0;
		for (String data : text) {
			out.println(data.replace("\n", "<br>"));
			out.println("<a href = \"http://localhost:8080/jmaster/BbsServlet2?action=remove"
					+ "&REMOVE=" + i + "\">[削除]</a>");
			out.println("<br><hr>");
			i++;
		}
		out.println("</body></html>");
	}

}
