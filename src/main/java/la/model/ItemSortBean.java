package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemSortBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			// セッションの取得
			HttpSession session = request.getSession(true);

			//リクエストパラメータを取得
			String key = request.getParameter("key");

			boolean ascending = key.equals("price_asc");

			//ItemDAOクラスのインスタンスを生成
			ItemDAO dao = new ItemDAO();

			String product;
			if (session.getAttribute("PRODUCT") == null) {
				product = "";
			} else {
				product = (String) session.getAttribute("PRODUCT");
			}
			int minPrice;
			if (session.getAttribute("MINPRICE") == null) {
				minPrice = 0;
			} else {
				minPrice = (int) session.getAttribute("MINPRICE");
			}
			int maxPrice;
			if (session.getAttribute("MAXPRICE") == null) {
				maxPrice = 99999;
			} else {
				maxPrice = (int) session.getAttribute("MAXPRICE");
			}

			List<Item> items = null;
			if (product.equals("")) {
				items = dao.sortPrice(ascending, minPrice, maxPrice);
			} else {
				items = dao.sortPrice(ascending, product, minPrice, maxPrice);
			}

			request.setAttribute("items", items);

			return "/la/showItem2.jsp";
		} catch (Exception e) {
			throw new DAOException("並び替えできません");
		}
	}

}
