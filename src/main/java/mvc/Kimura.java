package mvc;

import javax.servlet.http.HttpServletRequest;

public class Kimura implements Canon {
	public String calc(HttpServletRequest request) throws CanonException {
		try {
			// リクエストパラメータ
			int x = Integer.parseInt(request.getParameter("data1"));
			int y = Integer.parseInt(request.getParameter("data2"));

			int result = x - y;

			// 減算結果をJSPで表示できる準備
			request.setAttribute("result", result);

			return "/mvc/fukazawa.jsp";
		} catch (NumberFormatException e) {
			throw new CanonException("数値以外が入力されてるよ！");
		}
	}
}
