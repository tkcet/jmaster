package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.model.IBean;
import la.model.ItemDeleteBean;
import la.model.ItemDeletePageBean;
import la.model.ItemListBean;
import la.model.ItemRegistBean;
import la.model.ItemUpdateBean;
import la.model.ItemUpdatePageBean;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

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

		IBean bean = null;
		String page = "/la/errInternal.jsp";

		try {
			if (action == null || action.equals("")) {
				bean = new ItemListBean();
			} else if (action.equals("regist")) {
				bean = new ItemRegistBean();
			} else if (action.equals("update1")) {
				bean = new ItemUpdatePageBean();
			} else if (action.equals("update2")) {
				bean = new ItemUpdateBean();
			} else if (action.equals("delete1")) {
				bean = new ItemDeletePageBean();
			} else if (action.equals("delete2")) {
				bean = new ItemDeleteBean();
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
