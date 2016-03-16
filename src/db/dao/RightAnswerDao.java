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

//执行数据库的查、删、添加、更新操作
public class RightAnswerDao {
	// 批量查询
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

	// 学号是主码，可以根据学号查询
	public RightAnswer getRightAnswer(String qno) throws SQLException {

		String sql = "select * from rightAnswer where qno=?;";
		Connection conn = DBHelper.getDbConn();
		RightAnswer rightAnswer = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, qno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// 学号不对应时会让exam为null
			rightAnswer = new RightAnswer();
			rightAnswer.setQno(rst.getString("qno"));
			rightAnswer.setQanswer(rst.getString("qanswer"));
		}
		return rightAnswer;// 返回之后的后续处理-----需要判断是否为null然后反馈给用户
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

	// 没有对应eno时数据库不会报错，但这里会让exam=null
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
