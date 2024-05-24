package db.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.model.IBean;
import db.model.UserDeleteBean;
import db.model.UserDeleteExecBean;
import db.model.UserInsertBean;
import db.model.UserInsertExecBean;
import db.model.UserListBean;
import db.model.UserUpdateBean;
import db.model.UserUpdateExecBean;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/control")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// リクエスト・パラメータを取得
		String action = request.getParameter("action");

		String page = "/db/error.jsp";

		IBean bean = null;

		try {
			if (action.equals("list")) {
				// モデルのインスタンスを生成
				bean = new UserListBean();
				page = bean.execute(request);
			} else if (action.equals("insert")) {
				bean = new UserInsertBean();
				page = bean.execute(request);
			} else if (action.equals("insert_exec")) {
				bean = new UserInsertExecBean();
				page = bean.execute(request);
			} else if (action.equals("update")) {
				bean = new UserUpdateBean();
				page = bean.execute(request);
			} else if (action.equals("update_exec")) {
				bean = new UserUpdateExecBean();
				page = bean.execute(request);
			} else if (action.equals("delete")) {
				bean = new UserDeleteBean();
				page = bean.execute(request);
			} else if (action.equals("delete_exec")) {
				bean = new UserDeleteExecBean();
				page = bean.execute(request);
			} else {
				System.out.println("actionの設定ミス");
			}

			if (bean != null) {
				bean.execute(request);
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		// リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
