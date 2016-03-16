package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.Exam;
import db.DBHelper;

//ִ����ݿ�Ĳ顢ɾ����ӡ����²���
public class ExamDao {
	// ������ѯ
	public List<Exam> query() throws SQLException {

		List<Exam> exams = new ArrayList<Exam>();
		String sql = "select * from exam;";
		Connection conn = DBHelper.getDbConn();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			Exam exam = new Exam();
			exam.setEno(rst.getString("eno"));
			exam.setStartTime(new java.util.Date(rst.getDate("startTime").getTime()).toString());
			exam.setEndTime(new java.util.Date(rst.getDate("endTime").getTime()).toString());
			exams.add(exam);
		}
		return exams;
	}


	public Exam getExam(String eno) throws SQLException {

		String sql = "select * from exam where eno=?;";
		Connection conn = DBHelper.getDbConn();
		Exam exam = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, eno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {
			exam = new Exam();
			exam.setEno(rst.getString("eno"));
			exam.setStartTime(rst.getDate("startTime").toString());
			exam.setEndTime(rst.getDate("endTime").toString());
		}
		return exam;// ����֮��ĺ�����-----��Ҫ�ж��Ƿ�ΪnullȻ�������û�
	}

	public void del(String eno) throws SQLException {
		String sql = "delete from exam where eno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, eno);
		pst.execute();

	}

	public void add(Exam em) throws SQLException {
		String sql = "insert into exam(eno,startTime,endTime) values(?,?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, em.getEno());
		pst.setString(2, em.getStartTime());
		pst.setString(3, em.getEndTime());
		pst.execute();
	}

	// û�ж�Ӧenoʱ��ݿⲻ�ᱨ�?���������exam=null
	public void update(Exam em) throws SQLException {
		String sql = "update exam set startTime=?,endTime=? where eno=?";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(3, em.getEno());
		pst.setString(1, em.getStartTime());
		pst.setString(2, em.getEndTime());
		pst.execute();
		pst.close();
	}

}
