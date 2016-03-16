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

//执行数据库的查、删、添加、更新操作
public class QuestionsDao {
	// 批量查询
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

	// 学号是主码，可以根据学号查询
	public Questions getQuestion(String qno) throws SQLException {

		String sql = "select * from questions where qno=?;";
		Connection conn = DBHelper.getDbConn();
		Questions question = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, qno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// 学号不对应时会让exam为null
			question = new Questions();
			question.setQno(rst.getString("qno"));
			question.setQtype(rst.getInt("qtype"));
			question.setQvalue(rst.getInt("qvalue"));
			question.setQcontent(rst.getString("qcontent"));
		}
		return question;// 返回之后的后续处理-----需要判断是否为null然后反馈给用户
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

	// 没有对应eno时数据库不会报错，但这里会让exam=null
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
