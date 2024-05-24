package kadai30add;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WordServlet
 */
@WebServlet("/wordservlet")
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		// Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");
		// リクエスト・パラメータを取得
		String action = request.getParameter("action");

		if (action.equals("insert")) {
			// セッションオブジェクトを取得
			HttpSession session = request.getSession(true);

			WordBean word = new WordBean();

			String English = request.getParameter("English");
			String Japanese = request.getParameter("Japanese");

			word.setEnglish(English);
			word.setJapanese(Japanese);

			@SuppressWarnings("unchecked")
			List<WordBean> list = (List<WordBean>) session.getAttribute("WORD");

			if (list == null) {
				list = new ArrayList<>();
			}

			list.add(word);
			session.setAttribute("WORD", list);
			RequestDispatcher rd = request.getRequestDispatcher("/kadai30add/listword.jsp");
			rd.forward(request, response);
		} else if (action.equals("search")) {
			// セッションオブジェクトを取得
			HttpSession session = request.getSession(true);
			
			WordModel searchModel = new WordModel();
			List<WordBean> word = new ArrayList<>();

			word.add(searchModel.search(request));

			session.setAttribute("WORD", word);
			RequestDispatcher rd = request.getRequestDispatcher("/kadai30add/listword.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
