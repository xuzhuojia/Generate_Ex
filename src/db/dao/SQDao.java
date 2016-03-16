package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.SQ;
import db.DBHelper;

//ִ����ݿ�Ĳ顢ɾ����ӡ����²���
public class SQDao {
	// ������ѯ
	public List<SQ> query() throws SQLException {

		List<SQ> sqs = new ArrayList<SQ>();
		String sql = "select * from sq;";
		Connection conn = DBHelper.getDbConn();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			SQ sq = new SQ();
			sq.setSno(rst.getString("sno"));
			sq.setEno(rst.getString("eno"));
			sq.setQno(rst.getString("qno"));
			sq.setSanswer(rst.getString("sanswer"));
			sq.setQscore(rst.getInt("qscore"));
			sqs.add(sq);
		}
		return sqs;
	}

	// ѧ�������룬���Ը��ѧ�Ų�ѯ
	public List<SQ> getSQ(String sno, String eno) throws SQLException {

		List<SQ> sqs = new ArrayList<SQ>();
		String sql = "select * from sq where sno=? and eno=?;";
		Connection conn = DBHelper.getDbConn();
		SQ sq = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sno);
		pst.setString(2, eno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// ѧ�Ų���Ӧʱ����examΪnull
			sq = new SQ();
			sq.setSno(rst.getString("sno"));
			sq.setEno(rst.getString("eno"));
			sq.setQno(rst.getString("qno"));
			sq.setSanswer(rst.getString("sanswer"));
			sq.setQscore(rst.getInt("qscore"));
			sqs.add(sq);
		}
		return sqs;// ����֮��ĺ�����-----��Ҫ�ж��Ƿ�ΪnullȻ�������û�
	}

	public void del(String sno, String eno) throws SQLException {
		String sql = "delete from sq where sno=? and eno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sno);
		pst.setString(2, eno);
		pst.execute();

	}
	public void del2(String eno) throws SQLException {
		String sql = "delete from sq where eno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, eno);
		pst.execute();

	}

	public void add(SQ ssq) throws SQLException {
		String sql = "insert into sq(sno,eno,qno,sanswer,qscore) values(?,?,?,?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, ssq.getSno());
		pst.setString(2, ssq.getEno());
		pst.setString(3, ssq.getQno());
		pst.setString(4, ssq.getSanswer());
		pst.setInt(5, ssq.getQscore());
		pst.execute();
	}

	// û�ж�Ӧenoʱ��ݿⲻ�ᱨ�?���������exam=null
	public void update(SQ ssq) throws SQLException {
		String sql = "update sq set sanswer=?,qscore=? where sno=? and eno=? and qno=?";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(3, ssq.getSno());
		pst.setString(4, ssq.getEno());
		pst.setString(5, ssq.getQno());
		pst.setString(1, ssq.getSanswer());
		pst.setInt(2, ssq.getQscore());
		pst.execute();
		pst.close();
	}

}
