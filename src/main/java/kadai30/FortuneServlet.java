package kadai30;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FortuneServlet
 */
@WebServlet("/FortuneServlet")
public class FortuneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FortuneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String month = request.getParameter("MONTH");
		//int month = Integer.parseInt(monthStr);

		Random random = new Random();

		int num1 = random.nextInt(3);
		int num2 = random.nextInt(3);
		int num3 = random.nextInt(12) + 1;
		String color = "";
		String item = "";

		switch (num1) {
		case 0:
			color = "赤";
			break;
		case 1:
			color = "黄";
			break;
		case 2:
			color = "白";
			break;
		default:
			break;
		}

		switch (num2) {
		case 0:
			item = "タオル";
			break;
		case 1:
			item = "カバン";
			break;
		case 2:
			item = "腕時計";
			break;
		default:
			break;
		}

		FortuneBean bean = new FortuneBean(month, color, item, num3);

		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/kadai30/fortune.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
