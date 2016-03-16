package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.SE;
import db.DBHelper;

//ִ����ݿ�Ĳ顢ɾ����ӡ����²���
public class SEDao {
	// ������ѯ
	public List<SE> query() throws SQLException {

		List<SE> ses = new ArrayList<SE>();
		String sql = "select * from se;";
		Connection conn = DBHelper.getDbConn();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			SE se = new SE();
			se.setSno(rst.getString("sno"));
			se.setEno(rst.getString("eno"));
			se.setExamState(rst.getString("examState"));
			se.setScore(rst.getInt("score"));
			ses.add(se);
		}
		return ses;
	}

	// ѧ�������룬���Ը��ѧ�Ų�ѯ
	public List<SE> getSE(String sno) throws SQLException {
		List<SE> ses = new ArrayList<SE>();
		String sql = "select * from se where sno=?;";
		Connection conn = DBHelper.getDbConn();
		SE se = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// ѧ�Ų���Ӧʱ����examΪnull
			se = new SE();
			se.setSno(rst.getString("sno"));
			se.setEno(rst.getString("eno"));
			se.setExamState(rst.getString("examState"));
			se.setScore(rst.getInt("score"));
			ses.add(se);
		}
		return ses;
	}

	public void del(String sno) throws SQLException {
		String sql = "delete from se where sno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sno);
		pst.execute();
	}

	public void add(SE s) throws SQLException {
		String sql = "insert into se(sno,eno,examState,score) values(?,?,?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, s.getSno());
		pst.setString(2, s.getEno());
		pst.setString(3, s.getExamState());
		pst.setInt(4, s.getScore());
		pst.execute();
	}

	// û�ж�Ӧenoʱ��ݿⲻ�ᱨ�?���������exam=null
	public void update(SE s) throws SQLException {
		String sql = "update se set eno=?,examState=?,score=? where sno=?";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(4, s.getSno());
		pst.setString(1, s.getEno());
		pst.setString(2, s.getExamState());
		pst.setInt(3, s.getScore());
		pst.execute();
		pst.close();
	}

}
