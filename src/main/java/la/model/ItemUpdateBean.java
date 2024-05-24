package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemUpdateBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			//リクエストパラメータを取得
			int code = Integer.parseInt(request.getParameter("code"));
			int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));

			//ItemDAOクラスのインスタンスを生成
			ItemDAO dao = new ItemDAO();

			int rows = dao.UpdateItem(code, categoryCode, name, price);

			if (rows != 1) {
				throw new DAOException("更新に失敗しました。");
			}

			List<Item> items = dao.findAll();

			request.setAttribute("items", items);

			return "/la/showItem2.jsp";
		} catch (Exception e) {
			throw new DAOException("更新できません");
		}
	}

}
