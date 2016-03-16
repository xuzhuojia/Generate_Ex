package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Paper;
import db.DBHelper;

//执行数据库的查、删、添加、更新操作
public class PaperDao {
	// 批量查询
	public List<Paper> getPaper(String eno) throws SQLException {

		List<Paper> papers = new ArrayList<Paper>();
		String sql = "select * from paper where eno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, eno);
		ResultSet rst=pst.executeQuery();
		while (rst.next()) {
			Paper paper = new Paper();
			paper.setQno(rst.getString("qno"));
			paper.setEno(rst.getString("eno"));
			papers.add(paper);
		}
		return papers;
	}

	public void del(String eno) throws SQLException {
		String sql = "delete from paper where eno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, eno);
		pst.execute();
	}

	public void add(Paper q) throws SQLException {
		String sql = "insert into paper(eno,qno) values(?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, q.getEno());
		pst.setString(2, q.getQno());
		pst.execute();
	}
}
