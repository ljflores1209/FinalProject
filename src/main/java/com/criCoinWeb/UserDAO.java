package com.criCoinWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class UserDAO {
	private Connection con;
	private int max_records = 1000;
	private HttpSession session;

	public UserDAO() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://db-mysql-final-project-do-user-9229440-0.b.db.ondigitalocean.com:25060/proyecto_final",
					"luis", "z3rxgvnbrigspt5b");

			System.out.println("ok userDAO");

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public UserPojo getUser(int id) {

		UserPojo res = null;
		WalletDAO cartera = new WalletDAO();

		try {
			String sql = "select * from user where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				res = new UserPojo(rs.getInt("id_user"), rs.getString("nick"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("b_date"), rs.getString("country"), rs.getString("email"),
						rs.getString("pass"));
				res.setCartera(cartera.getWalletUser(rs.getInt("id_user")));

			}

		} catch (Exception ex) {
			System.out.println(ex);

		}
		return res;
	}

	public int getUserIdByEmail(String email) {

		try {
			String sql = "select * from user where email = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("aqui estoy");

				return rs.getInt("id_user");
			}
		} catch (Exception ex) {
			System.out.println(ex);

		}
		return -1;
	}

	public List<UserPojo> getUsers() {
		try {
			String sql = "select * from user limit ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, max_records);

			ResultSet rs = stmt.executeQuery();

			List<UserPojo> userList = new ArrayList<UserPojo>();

			while (rs.next()) {
				UserPojo user = new UserPojo(rs.getInt("id_user"), rs.getString("nick"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("b_date"), rs.getString("country"), rs.getString("email"),
						rs.getString("pass"));

				userList.add(user);
			}
			return userList;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	public int addUser(UserPojo user) {
		try {
			String sql = "insert into user (nick,first_name,last_name,b_date,country,email,pass) values (?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getNick());
			stmt.setString(2, user.getFirst_name());
			stmt.setString(3, user.getLast_name());
			stmt.setDate(4, user.getB_date());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getEmail());
			stmt.setString(7, user.getPass());

			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}

	public int addUserRegistro(UserPojo user) {
		try {
			String sql = "insert into user (email,pass) values (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPass());

			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}

	public int deleteUser(int id) {
		try {
			String sql = "delete from user where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			int res = stmt.executeUpdate();
			return res;

		} catch (Exception ex) {
			System.out.println(ex);
			return -1;
		}
	}

	public int updateUser(UserPojo user, int id) {
		try {
			String sql = "update user set nick=?, first_name=?, last_name=?,b_date=?, country=?,email=?, pass=? where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getNick());
			stmt.setString(2, user.getFirst_name());
			stmt.setString(3, user.getLast_name());
			stmt.setDate(4, user.getB_date());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getEmail());
			stmt.setString(7, user.getPass());
			stmt.setInt(8, id);

			int res = stmt.executeUpdate();
			return res;
		} catch (Exception ex) {

			System.out.println(ex.getMessage());
			return -1;

		}
	}

	public boolean comprobarEmail(String email) {
		try {
			String sql = "SELECT * FROM user where email = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, email);

			ResultSet res = stmt.executeQuery();

			return res.next();

		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}

	}
	
	

	public int getUserIdByPass(String pass) {
		try {
			String sql = "select id_user from user where pass = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, pass);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("aqui estoy");
				return rs.getInt("id_user");
			}
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		}
		return -1;
	}

	public boolean comprobarLogin(String email, String pass) {	
		if(getUserIdByPass(pass)==getUserIdByEmail(email)) {
			System.out.println(getUserIdByPass(pass));
			System.out.println(getUserIdByEmail(email));		
			return true;
		}else {
			return false;
		}
	}



//--------------------------inicio sesion -----------------------------------------------
	public UserPojo getLogin(int id) {
		UserPojo user;
		try {
			String sql = "select name,pass from user where id_user=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.setInt(1, id);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserPojo(rs.getInt("id_user"), rs.getString("nick"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("b_date"), rs.getString("country"), rs.getString("email"),
						rs.getString("pass"));
				return user;
			} else {
				return null;
			}

		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

}
