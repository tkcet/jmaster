package kadai10;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BbsServlet
 */
@WebServlet("/BbsServlet")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsServlet() {
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
	List<String> text = new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		if (action.equals("write")) {
			// 現在日時を取得
			LocalDateTime date = LocalDateTime.now();

			// 表示形式を指定
			DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

			String sdate = dtformat.format(date);
			// リクエスト読み込み
			String name = request.getParameter("NAME");
			text.add(sdate + "　" + name + "：" + request.getParameter("TEXT"));
			html(request, response, text);
		} else if (action.equals("remove")) {
			String strNum = request.getParameter("REMOVE");
			int num = Integer.parseInt(strNum);
			text.remove(num);
			html(request, response, text);
		} else {
			out.println("<html><head><title>掲示板</title></head><body>");
			out.println("<form action=\"http://localhost:8080/jmaster/kadai10/bbs.html\" method=\"POST\">");
			out.println("操作エラー<br>");
			out.println("<a href = \"http://localhost:8080/jmaster/kadai10/bbs.html\">戻る</a>");
			out.println("</form>");
			out.println("</body></html>");
		}

		for (String data : text) {
			if (data == null) {
				showNotEnterError(out);
				return;
			}
		}
	}

	private void html(HttpServletRequest request, HttpServletResponse response, List<String> text)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>掲示板</title></head><body>");
		out.println("<form action=\"http://localhost:8080/jmaster/BbsServlet?action=write\" method=\"POST\">");
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
			out.println("<a href = \"http://localhost:8080/jmaster/BbsServlet?action=remove"
					+ "&REMOVE=" + i + "\">[削除]</a>");
			out.println("<br><hr>");
			i++;
		}
		out.println("</body></html>");
	}

	private void showNotEnterError(PrintWriter out) {
		out.println("<html><head><title>掲示板</title></head><body>");
		out.println("<h1>入力してください</h1>");
		out.println("</body></html>");
	}

}
