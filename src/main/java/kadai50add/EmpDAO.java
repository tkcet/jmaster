package kadai50add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.dao.DAOException;

public class EmpDAO extends DAO {

	public List<Emp> search(int minAge, int maxAge) throws DAOException {
		List<Emp> emps = new ArrayList<>();

		String sql = "SELECT code, name, age, tel FROM emp WHERE age BETWEEN ? AND ?";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, minAge);
			ps.setInt(2, maxAge);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				String code = rs.getString("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");

				emps.add(new Emp(code, name, age, tel));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return emps;
	}
	
	public List<Emp> desc(int rank) throws DAOException {
		List<Emp> emps = new ArrayList<>();

		String sql = "SELECT code, name, age, tel FROM emp ORDER BY age DESC LIMIT ?";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rank);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				String code = rs.getString("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");

				emps.add(new Emp(code, name, age, tel));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return emps;
	}
}
