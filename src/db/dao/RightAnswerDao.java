package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.RightAnswer;
import db.DBHelper;

//ִ�����ݿ�Ĳ顢ɾ����ӡ����²���
public class RightAnswerDao {
	// ������ѯ
	public List<RightAnswer> query() throws SQLException {

		List<RightAnswer> rightAnswers = new ArrayList<RightAnswer>();
		String sql = "select * from rightAnswer;";
		Connection conn = DBHelper.getDbConn();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			RightAnswer rightAnswer = new RightAnswer();
			rightAnswer.setQno(rst.getString("qno"));
			rightAnswer.setQanswer(rst.getString("qanswer"));
			rightAnswers.add(rightAnswer);
		}
		return rightAnswers;
	}

	// ѧ�������룬���Ը���ѧ�Ų�ѯ
	public RightAnswer getRightAnswer(String qno) throws SQLException {

		String sql = "select * from rightAnswer where qno=?;";
		Connection conn = DBHelper.getDbConn();
		RightAnswer rightAnswer = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, qno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// ѧ�Ų���Ӧʱ����examΪnull
			rightAnswer = new RightAnswer();
			rightAnswer.setQno(rst.getString("qno"));
			rightAnswer.setQanswer(rst.getString("qanswer"));
		}
		return rightAnswer;// ����֮��ĺ�������-----��Ҫ�ж��Ƿ�ΪnullȻ�������û�
	}

	public void del(String qno) throws SQLException {
		String sql = "delete from rightAnswer where qno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, qno);
		pst.execute();
	}

	public void add(RightAnswer q) throws SQLException {
		String sql = "insert into rightAnswer(qno,qanswer) values(?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, q.getQno());
		pst.setString(2, q.getQanswer());
		pst.execute();
	}

	// û�ж�Ӧenoʱ���ݿⲻ�ᱨ�����������exam=null
	public void update(RightAnswer q) throws SQLException {
		String sql = "update rightAnswer set qanswer=? where qno=?";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(2, q.getQno());
		pst.setString(1, q.getQanswer());
		pst.execute();
		pst.close();
	}

}
