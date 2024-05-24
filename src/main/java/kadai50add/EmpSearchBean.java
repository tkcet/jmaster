package kadai50add;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import la.dao.DAOException;

public class EmpSearchBean implements EBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			// セッションの取得
			HttpSession session = request.getSession(true);
			
			int minAge = Integer.parseInt(request.getParameter("MINAGE"));
			int maxAge = Integer.parseInt(request.getParameter("MAXAGE"));

			//ItemDAOクラスのインスタンスを生成
			EmpDAO dao = new EmpDAO();
			List<Emp> emps = new ArrayList<>();

			emps = dao.search(minAge, maxAge);
			request.setAttribute("emps", emps);
			
			session.setAttribute("MIN", minAge);
			session.setAttribute("MAX", maxAge);

			return "/kadai50add/emp.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("正しい年齢を入力してください");
		}
	}

}
