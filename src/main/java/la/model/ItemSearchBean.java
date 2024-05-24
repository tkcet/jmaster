package la.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemSearchBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			// セッションの取得
			HttpSession session = request.getSession(true);

			String product = request.getParameter("product");
			int minPrice, maxPrice;

			//リクエストパラメータを取得
			if (!product.equals("")) {
				session.setAttribute("PRODUCT", product);
			} else {
				session.setAttribute("PRODUCT", "");
			}
			if (request.getParameter("minPrice").equals("")) {
				minPrice = 0;
				session.setAttribute("MINPRICE", "");
			} else {
				minPrice = Integer.parseInt(request.getParameter("minPrice"));
				session.setAttribute("MINPRICE", minPrice);
			}
			if (request.getParameter("maxPrice").equals("")) {
				maxPrice = 99999;
				session.setAttribute("MAXPRICE", "");
			} else {
				maxPrice = Integer.parseInt(request.getParameter("maxPrice"));
				session.setAttribute("MAXPRICE", maxPrice);
			}

			//ItemDAOクラスのインスタンスを生成
			ItemDAO dao = new ItemDAO();
			List<Item> items = new ArrayList<>();

			if (product.equals("")) {
				items = dao.findByPrice(minPrice, maxPrice);
			} else {
				items = dao.findBy(product, minPrice, maxPrice);
			}

			request.setAttribute("items", items);

			return "/la/showItem2.jsp";
		} catch (Exception e) {
			throw new DAOException("検索できません");
		}
	}

}
