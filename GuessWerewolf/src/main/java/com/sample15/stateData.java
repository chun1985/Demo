
package com.sample15;

import java.sql.*;
import java.util.ArrayList;

public class stateData {
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private int max = 0;
	private String result = "";

	public int getMax() {
		return max;
	}

	public String getResult() {
		return result;
	}

	public void linkToDB() throws Exception {
		String url = "jdbc:sqlserver://VMSQL:7531;databaseName=javaDB", user = "java", pw = "java";
		// 啟動驅動程式
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// 連線
		con = DriverManager.getConnection(url, user, pw);
		stmt = con.createStatement();
	}

	public void createTable() throws SQLException {
		DatabaseMetaData dbm = con.getMetaData();
		ResultSet rs = dbm.getTables(null, null, "玩家身分", null);

		if (!rs.next()) {
			String sql = "CREATE TABLE 玩家身分(" + "回合 INTEGER PRIMARY KEY NOT NULL, " + "玩家1 NVARCHAR(6), "
					+ "玩家2 NVARCHAR(6), " + "玩家3 NVARCHAR(6), " + "玩家4 NVARCHAR(6), " + "玩家5 NVARCHAR(6), "
					+ "玩家6 NVARCHAR(6), " + "玩家7 NVARCHAR(6), " + "玩家8 NVARCHAR(6), " + "玩家9 NVARCHAR(6), "
					+ "玩家10 NVARCHAR(6))";
			stmt.execute(sql);
		}
	}

	public void insertData(ArrayList<Character> list) throws SQLException {
		String sql = "INSERT INTO 玩家身分 (回合, 玩家1, 玩家2, 玩家3, 玩家4, 玩家5, 玩家6, 玩家7, 玩家8, 玩家9, 玩家10) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		roundMax();
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, ++max);
		pstmt.setString(2, list.get(0).toString());
		pstmt.setString(3, list.get(1).toString());
		pstmt.setString(4, list.get(2).toString());
		pstmt.setString(5, list.get(3).toString());
		pstmt.setString(6, list.get(4).toString());
		pstmt.setString(7, list.get(5).toString());
		pstmt.setString(8, list.get(6).toString());
		pstmt.setString(9, list.get(7).toString());
		pstmt.setString(10, list.get(8).toString());
		pstmt.setString(11, list.get(9).toString());
		pstmt.execute();
	}

	public void queryData() throws SQLException {
		roundMax();
		for (int i = 1; i < 11; i++) {
			doQueryData(i, "狼人");
		}
		stmt.close();
	}

	public void queryData(int player) throws SQLException {
		roundMax();
		doQueryData(player, "狼人");
		doQueryData(player, "預言家");
		doQueryData(player, "女巫");
		doQueryData(player, "獵人");
		doQueryData(player, "平民");
		stmt.close();
	}

	public void upData(int round, ArrayList<Character> list) throws SQLException {
		String sql = "UPDATE 玩家身分 " + "SET 玩家1='" + list.get(0).toString() + "', 玩家2='" + list.get(1).toString()
				+ "', 玩家3='" + list.get(2).toString() + "', 玩家4='" + list.get(3).toString() + "', 玩家5='"
				+ list.get(4).toString() + "', 玩家6='" + list.get(5).toString() + "', 玩家7='" + list.get(6).toString()
				+ "', 玩家8='" + list.get(7).toString() + "', 玩家9='" + list.get(8).toString() + "', 玩家10='"
				+ list.get(9).toString() + "' WHERE 回合=" + round;

		result = "第 <font color='#00d1d1'>" + round + "</font> 回合<br>";
		result += doQueryRound("修改前", round);
		stmt.executeUpdate(sql);
		result += doQueryRound("修改後", round);
		stmt.close();
	}

	public void deleteData() throws SQLException {
		roundMax();
		max -= 10;
		if (max < 1) {
			dropTable();
		} else {
			String sql = "DELETE FROM 玩家身分 WHERE 回合 >" + max;
			stmt.executeUpdate(sql);
			stmt.close();
		}
	}

	public void dropTable() throws SQLException {
		String sql = "DROP TABLE 玩家身分";

		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void closeState() throws SQLException {
		pstmt.close();
		stmt.close();
	}

	private void roundMax() throws SQLException {
		String sql = "SELECT MAX (回合) FROM 玩家身分";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			max = rs.getInt(1);
		}
		result = String.format("經過 <font color='#00d1d1'>%d</font> 回合<p>", max);
	}

	private void doQueryData(int player, String character) throws SQLException {
		String sql = "SELECT 玩家" + player + " FROM 玩家身分 WHERE 玩家" + player + "='" + character + "'";
		ResultSet rs = stmt.executeQuery(sql);
		double count = 0;

		while (rs.next()) {
			count++;
		}
		int chance = (int) ((count / max) * 100);
		result += String.format(
				"玩家 <font color='#0000ff'>%02d</font> 拿到" + character
						+ " <font color='#ffb326'>%d</font> 次，機率為 <font color='#ff0000'>%2d</font> %%<br>",
				player, (int) count, chance);
	}

	private String doQueryRound(String str, int round) throws SQLException {
		String sql = "SELECT * FROM 玩家身分 WHERE 回合 =" + round;
		ResultSet rs = stmt.executeQuery(sql);
		String result = "";

		while (rs.next()) {
			result = String.format("<font color='#ff0000'>%s</font><br>"
					+ "玩家<font color='#0000ff'>01</font> 拿到 <font color='#ffb326'>%s</font><br> 玩家<font color='#0000ff'>02</font> 拿到 <font color='#ffb326'>%s</font><br> "
					+ "玩家<font color='#0000ff'>03</font> 拿到 <font color='#ffb326'>%s</font><br> 玩家<font color='#0000ff'>04</font> 拿到 <font color='#ffb326'>%s</font><br> "
					+ "玩家<font color='#0000ff'>05</font> 拿到 <font color='#ffb326'>%s</font><br> 玩家<font color='#0000ff'>06</font> 拿到 <font color='#ffb326'>%s</font><br> "
					+ "玩家<font color='#0000ff'>07</font> 拿到 <font color='#ffb326'>%s</font><br> 玩家<font color='#0000ff'>08</font> 拿到 <font color='#ffb326'>%s</font><br> "
					+ "玩家<font color='#0000ff'>09</font> 拿到 <font color='#ffb326'>%s</font><br> 玩家<font color='#0000ff'>10</font> 拿到 <font color='#ffb326'>%s</font><p>",
					str, rs.getString("玩家1"), rs.getString("玩家2"), rs.getString("玩家3"), rs.getString("玩家4"),
					rs.getString("玩家5"), rs.getString("玩家6"), rs.getString("玩家7"), rs.getString("玩家8"),
					rs.getString("玩家9"), rs.getString("玩家10"));
		}
		return result;
	}
}
