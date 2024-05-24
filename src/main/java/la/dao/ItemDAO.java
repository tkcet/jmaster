package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.dao.DAOException;
import la.bean.Item;

public class ItemDAO extends DAO {

	//全件検索メソッド
	public List<Item> findAll() throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, category_code, name, price FROM item ORDER BY code";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code"); //codeの列のデータを取得
				int categoryCode = rs.getInt("category_code");
				String name = rs.getString("name"); //nameの列のデータを取得
				int price = rs.getInt("price"); //priceの列のデータを取得

				list.add(new Item(code, categoryCode, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}

		return list;
	}

	//全件検索メソッド（単価の高い順または低い順でソート）
	public List<Item> sortPrice(boolean ascending, int minPrice, int maxPrice) throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, category_code, name, price FROM item WHERE price BETWEEN ? AND ? ORDER BY price ";

		sql += (ascending ? "ASC" : "DESC");

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, minPrice);
			ps.setInt(2, maxPrice);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code"); //codeの列のデータを取得
				int categoryCode = rs.getInt("category_code");
				String name = rs.getString("name"); //nameの列のデータを取得
				int price = rs.getInt("price"); //priceの列のデータを取得

				list.add(new Item(code, categoryCode, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return list;
	}

	//全件検索メソッド（単価の高い順または低い順でソート）
	public List<Item> sortPrice(boolean ascending, String product, int minPrice, int maxPrice) throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, category_code, name, price FROM item WHERE name LIKE ? AND price BETWEEN ? AND ? ORDER BY price ";

		sql += (ascending ? "ASC" : "DESC");

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + product + "%");
			ps.setInt(2, minPrice);
			ps.setInt(3, maxPrice);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code"); //codeの列のデータを取得
				int categoryCode = rs.getInt("category_code");
				String name = rs.getString("name"); //nameの列のデータを取得
				int price = rs.getInt("price"); //priceの列のデータを取得

				list.add(new Item(code, categoryCode, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return list;
	}

	//複数件検索メソッド（指定した単価以下の商品を取得）
	public List<Item> findByPrice(int minPrice, int maxPrice) throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, category_code, name, price FROM item WHERE ? <= price AND price <= ?";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, minPrice);
			ps.setInt(2, maxPrice);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code"); //codeの列のデータを取得
				int categoryCode = rs.getInt("category_code");
				String name = rs.getString("name"); //nameの列のデータを取得
				int price = rs.getInt("price"); //priceの列のデータを取得

				list.add(new Item(code, categoryCode, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return list;
	}

	//複数件検索メソッド
	public List<Item> findBy(String product, int minPrice, int maxPrice) throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, category_code, name, price FROM item WHERE ? <= price AND price <= ? AND name LIKE ?";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, minPrice);
			ps.setInt(2, maxPrice);
			ps.setString(3, "%" + product + "%");

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code"); //codeの列のデータを取得
				int categoryCode = rs.getInt("category_code");
				String name = rs.getString("name"); //nameの列のデータを取得
				int price = rs.getInt("price"); //priceの列のデータを取得

				list.add(new Item(code, categoryCode, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return list;
	}

	//登録メソッド
	public int addItem(String name, int price) throws DAOException {
		int rows = 0;

		String sql = "INSERT INTO item(name, price) VALUES(?, ?)";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, price);

			//SQLを実行して結果を取得する
			rows = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return rows;
	}

	//削除メソッド
	public int deleteByPrimaryKey(int key) throws DAOException {
		int rows = 0;

		String sql = "DELETE FROM item WHERE code = ?";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);

			//SQLを実行して結果を取得する
			rows = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return rows;
	}

	//登録メソッド
	public int registItem(int categoryCode, String name, int price) throws DAOException {
		int rows = 0;

		String sql = "INSERT INTO item(category_code, name, price) VALUES(?, ?, ?)";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryCode);
			ps.setString(2, name);
			ps.setInt(3, price);

			//SQLを実行して結果を取得する
			rows = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return rows;
	}

	//更新メソッド
	public int UpdateItem(int code, int categoryCode, String name, int price) throws DAOException {
		int rows = 0;

		String sql = "UPDATE item SET category_code = ?, name = ?, price = ? WHERE code = ?";

		try (
				//正常にDBに接続された時に利用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryCode);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setInt(4, code);

			//SQLを実行して結果を取得する
			rows = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return rows;
	}

	// 単一検索メソッド
	public Item findById(int _code) throws DAOException {
		Item i = null;

		String sql = "SELECT code, category_code, name, price FROM item WHERE code = ?";

		try (//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			PreparedStatement ps = con.prepareStatement(sql);
			// プレースホルダー
			ps.setInt(1, _code);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// レコードの列のデータを取得
				int code = rs.getInt("code"); // idの列のデータを取得
				int categoryCode = rs.getInt("category_code");
				String name = rs.getString("name"); // nameの列のデータを取得
				int price = rs.getInt("price");

				i = new Item(code, categoryCode, name, price);
			}
		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
		}
		return i;
	}
}
