package kadai30add;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WordModel {
	public WordBean search(HttpServletRequest request) {
		//文字化け対策
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// セッションオブジェクトを取得
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<WordBean> list = (List<WordBean>) session.getAttribute("WORD");
		WordBean result = new WordBean();

		if (list == null) {
			list = new ArrayList<>();
		}

		String searchWord = request.getParameter("searchWord");

		for (WordBean data : list) {
			if (data.getEnglish().matches(".*" + searchWord + ".*")) {
				result.setEnglish(data.getEnglish());
				result.setJapanese(data.getJapanese());
				break;
			}
			if (data.getJapanese().matches(".*" + searchWord + ".*")) {
				result.setEnglish(data.getEnglish());
				result.setJapanese(data.getJapanese());
				break;
			}
		}

		return result;
	}
}
