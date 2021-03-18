package useBean;

import java.sql.*;

public class setNumber {
	private String[] number = new String[8];

	public String[] getNumber() {
		return number;
	}

	public void readNumForDB(String userTime) throws Exception {
		String url = "jdbc:mysql://localhost:3306/javadb?serverTimezone=CST", user = "root", pw = "root", sql = "";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 載入驅動程式
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 連線
		con = DriverManager.getConnection(url, user, pw);
	
		stmt = con.createStatement();
		sql = ("select * from receipt where time = " + userTime);
		rs = stmt.executeQuery(sql);
		rs.next();

		number[0] = rs.getString("number1");
		number[1] = rs.getString("number2");
		number[2] = rs.getString("number3");
		number[3] = rs.getString("special1");
		number[4] = rs.getString("special2");
		number[5] = rs.getString("spe6num1");
		number[6] = rs.getString("spe6num2");
		number[7] = rs.getString("spe6num3");
	}
}
