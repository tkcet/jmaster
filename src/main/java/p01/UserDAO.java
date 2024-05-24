package p01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {
	// 単一検索メソッド
	public User findById(String _id) throws DAOException {
		User u = null;

		String sql = "SELECT id, name, age FROM users WHERE id = ?";

		try (//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			PreparedStatement ps = con.prepareStatement(sql);
			// プレースホルダー
			ps.setString(1, _id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// レコードの列のデータを取得
				String id = rs.getString("id"); // idの列のデータを取得
				String name = rs.getString("name"); // nameの列のデータを取得
				int age = rs.getInt("age");

				u = new User(id, name, age);
			}
		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
		}
		return u;
	}

	// 全件検索メソッド
	public List<User> findAll() throws DAOException {
		List<User> users = new ArrayList<>();

		String sql = "SELECT id, name, age FROM users";

		try (//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			PreparedStatement ps = con.prepareStatement(sql);
			// プレースホルダー
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// レコードの列のデータを取得
				String id = rs.getString("id"); // idの列のデータを取得
				String name = rs.getString("name"); // nameの列のデータを取得
				int age = rs.getInt("age");

				//User u = new User(id, name, age);
				//users.add(u);
				users.add(new User(id, name, age));

			}
		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
		}
		return users;
	}

	// 登録メソッド
	public boolean insert(String id, String name, int age) throws DAOException {
		boolean check = false;

		String sql = "INSERT INTO users VALUES(?, ?, ?)";

		try (//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			// プレースホルダー
			int row = ps.executeUpdate();

			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
		}
		return check;
	}

	// 登録メソッド
	public boolean insert(User u) throws DAOException {
		boolean check = false;

		String id = u.getId();
		String name = u.getName();
		int age = u.getAge();

		String sql = "INSERT INTO users VALUES(?, ?, ?)";

		try (//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			// プレースホルダー
			int row = ps.executeUpdate();

			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
		}
		return check;
	}

	// 更新メソッド
	public boolean update(String id, String name, int age) throws DAOException {
		boolean check = false;

		String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";

		try (//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, id);
			// プレースホルダー
			int row = ps.executeUpdate();

			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
		}
		return check;
	}

	// 削除メソッド
	public boolean delete(String id) throws DAOException {
		boolean check = false;

		String sql = "DELETE FROM users WHERE id = ?";

		try (//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			// プレースホルダー
			int row = ps.executeUpdate();

			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
		}
		return check;
	}
}
