package mvc;

import javax.servlet.http.HttpServletRequest;

public interface Canon {
	public abstract String calc(HttpServletRequest request) throws CanonException;
}
