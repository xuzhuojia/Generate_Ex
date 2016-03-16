package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Teacher;
import db.DBHelper;

//执行数据库的查、删、添加、更新操作
public class TeacherDao {
	// 批量查询
	public List<Teacher> query() throws SQLException {

		List<Teacher> teachers = new ArrayList<Teacher>();
		String sql = "select * from teacher;";
		Connection conn = DBHelper.getDbConn();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			Teacher teacher = new Teacher();
			teacher.setTno(rst.getString("tno"));
			teacher.setTname(rst.getString("tname"));
			teacher.setTsex(rst.getString("tsex"));
			teacher.setTpw(rst.getString("tpw"));
			teacher.setTclass(rst.getString("tclass"));
			teachers.add(teacher);
		}
		return teachers;
	}

	// 学号是主码，可以根据学号查询
	public Teacher getTeacher(String tno) throws SQLException {

		String sql = "select * from teacher where tno=?;";
		Connection conn = DBHelper.getDbConn();
		Teacher teacher = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, tno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// 学号不对应时会让student为null
			teacher = new Teacher();
			teacher.setTno(rst.getString("tno"));
			teacher.setTname(rst.getString("tname"));
			teacher.setTsex(rst.getString("tsex"));
			teacher.setTpw(rst.getString("tpw"));
			teacher.setTclass(rst.getString("tclass"));
		}
		return teacher;// 返回之后的后续处理-----需要判断是否为null然后反馈给用户
	}

	public void del(String tno) throws SQLException {
		String sql = "delete from teacher where tno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, tno);
		pst.execute();
	}

	public void add(Teacher t) throws SQLException {
		String sql = "insert into teacher(tno,tname,tsex,tpw,tclass) values(?,?,?,?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, t.getTno());
		pst.setString(2, t.getTname());
		pst.setString(3, t.getTsex());
		pst.setString(4, t.getTpw());
		pst.setString(5, t.getTclass());
		pst.execute();
	}

	// 没有对应eno时数据库不会报错，但这里会让student=null
	public void update(Teacher t) throws SQLException {
		String sql = "update teacher set tname=?,tsex=?,tpw=?,tclass=? where tno=?";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(5, t.getTno());
		pst.setString(1, t.getTname());
		pst.setString(2, t.getTsex());
		pst.setString(3, t.getTpw());
		pst.setString(4, t.getTclass());
		pst.execute();
	}
}
