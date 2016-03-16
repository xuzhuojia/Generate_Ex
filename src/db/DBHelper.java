package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 加载数据库驱动，连接数据库
 **/
public class DBHelper {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=ExamMS";
	private static String userName = "sa";
	private static String userPwd = "123456";
	private static Connection dbConn=null;
	public static Connection getDbConn() {
		return dbConn;
	}
	static {
		try {
			Class.forName(driverName);
			System.out.println("数据库驱动加载成功！！！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库驱动加载失败！！！");
		}
		try {
			dbConn = DriverManager.getConnection(dbURL, userName,
					userPwd);
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server连接失败");
		}
	}
}
