package kadai50add;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
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

		//リクエストパラメータを取得
		String action = request.getParameter("action");

		EBean bean = null;
		String page = "/kadai50add/error.jsp";

		try {
			if (action.equals("search")) {
				bean = new EmpSearchBean();
			}else if(action.equals("desc")) {
				bean = new EmpAscBean();
			}
			page = bean.execute(request);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
