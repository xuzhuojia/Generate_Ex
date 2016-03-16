package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.Questions;
import db.DBHelper;

//ִ�����ݿ�Ĳ顢ɾ����ӡ����²���
public class QuestionsDao {
	// ������ѯ
	public List<Questions> query() throws SQLException {

		List<Questions> questions = new ArrayList<Questions>();
		String sql = "select * from questions;";
		Connection conn = DBHelper.getDbConn();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			Questions question = new Questions();
			question.setQno(rst.getString("qno"));
			question.setQtype(rst.getInt("qtype"));
			question.setQvalue(rst.getInt("qvalue"));
			question.setQcontent(rst.getString("qcontent"));
			questions.add(question);
		}
		return questions;
	}

	// ѧ�������룬���Ը���ѧ�Ų�ѯ
	public Questions getQuestion(String qno) throws SQLException {

		String sql = "select * from questions where qno=?;";
		Connection conn = DBHelper.getDbConn();
		Questions question = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, qno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// ѧ�Ų���Ӧʱ����examΪnull
			question = new Questions();
			question.setQno(rst.getString("qno"));
			question.setQtype(rst.getInt("qtype"));
			question.setQvalue(rst.getInt("qvalue"));
			question.setQcontent(rst.getString("qcontent"));
		}
		return question;// ����֮��ĺ�������-----��Ҫ�ж��Ƿ�ΪnullȻ�������û�
	}

	public void del(String qno) throws SQLException {
		String sql = "delete from questions where qno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, qno);
		pst.execute();
	}

	public void add(Questions q) throws SQLException {
		String sql = "insert into questions(qno,qtype,qvalue,qcontent) values(?,?,?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, q.getQno());
		pst.setInt(2, q.getQtype());
		pst.setInt(3, q.getQvalue());
		pst.setString(4, q.getQcontent());
		pst.execute();
	}

	// û�ж�Ӧenoʱ���ݿⲻ�ᱨ�����������exam=null
	public void update(Questions q) throws SQLException {
		String sql = "update questions set qtype=?,qvalue=?,qcontent=? where qno=?";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(4, q.getQno());
		pst.setInt(1, q.getQtype());
		pst.setInt(2, q.getQvalue());
		pst.setString(3, q.getQcontent());
		pst.execute();
		pst.close();
	}
}
