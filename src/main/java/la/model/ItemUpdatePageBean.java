package la.model;

import javax.servlet.http.HttpServletRequest;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemUpdatePageBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			//リクエストパラメータを取得
			int code = Integer.parseInt(request.getParameter("CODE"));

			// UserDAOのインスタンスを生成
			ItemDAO dao = new ItemDAO();

			Item item = dao.findById(code);

			if (item == null) {
				throw new DAOException("指定したコードの商品が見つかりません");
			}

			request.setAttribute("ITEM", item);

			return "/la/updateItem.jsp";
		} catch (Exception e) {
			throw new DAOException("aaa更新できません");
		}
	}

}
