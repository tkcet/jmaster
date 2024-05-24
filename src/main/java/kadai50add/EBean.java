package kadai50add;

import javax.servlet.http.HttpServletRequest;

import la.dao.DAOException;

public interface EBean {
	public abstract String execute(HttpServletRequest request) throws DAOException;
}
