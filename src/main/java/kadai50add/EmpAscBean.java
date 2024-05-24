package kadai50add;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import la.dao.DAOException;

public class EmpAscBean implements EBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			// セッションの取得
			HttpSession session = request.getSession(true);
			int rank = Integer.parseInt(request.getParameter("RANK"));

			//ItemDAOクラスのインスタンスを生成
			EmpDAO dao = new EmpDAO();
			List<Emp> emps = new ArrayList<>();

			emps = dao.desc(rank);
			request.setAttribute("emps", emps);
			
			session.setAttribute("NUM", rank);

			return "/kadai50add/emp.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("正しい人数を入力してください");
		}
	}

}
