package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Student;
import db.DBHelper;

//执行数据库的查、删、添加、更新操作
public class StudentDao {
	// 批量查询
	public List<Student> query() throws SQLException {

		List<Student> students = new ArrayList<Student>();
		String sql = "select * from student;";
		Connection conn = DBHelper.getDbConn();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			Student student = new Student();
			student.setSno(rst.getString("sno"));
			student.setSname(rst.getString("sname"));
			student.setSsex(rst.getString("ssex"));
			student.setSpw(rst.getString("spw"));
			student.setSclass(rst.getString("sclass"));
			students.add(student);
		}
		return students;
	}

	// 学号是主码，可以根据学号查询
	public Student getStudent(String sno) throws SQLException {

		String sql = "select * from student where sno=?;";
		Connection conn = DBHelper.getDbConn();
		Student student = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// 学号不对应时会让student为null
			student = new Student();
			student.setSno(rst.getString("sno"));
			student.setSname(rst.getString("sname"));
			student.setSsex(rst.getString("ssex"));
			student.setSpw(rst.getString("spw"));
			student.setSclass(rst.getString("sclass"));
		}
		return student;// 返回之后的后续处理-----需要判断是否为null然后反馈给用户
	}

	// 可以根据班级批量查询
	public List<Student> getStudents(String sclass) throws SQLException {

		List<Student> students = new ArrayList<Student>();
		String sql = "select * from student where sclass=?;";
		Connection conn = DBHelper.getDbConn();
		Student student = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sclass);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {
			student = new Student();
			student.setSno(rst.getString("sno"));
			student.setSname(rst.getString("sname"));
			student.setSsex(rst.getString("ssex"));
			student.setSpw(rst.getString("spw"));
			student.setSclass(rst.getString("sclass"));
			students.add(student);
		}
		return students;// 返回之后的后续处理-----需要判断是否为null然后反馈给用户
	}
	public void del(String sno) throws SQLException {
		String sql = "delete from student where sno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sno);
		pst.execute();

	}

	public void add(Student st) throws SQLException {
		String sql = "insert into student(sno,sname,ssex,spw,sclass) values(?,?,?,?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, st.getSno());
		pst.setString(2, st.getSname());
		pst.setString(3, st.getSsex());
		pst.setString(4, st.getSpw());
		System.out.println("1");
		pst.setString(5, st.getSclass());
		System.out.println("2");
		pst.execute();
	}

	// 没有对应eno时数据库不会报错，但这里会让student=null
	public void update(Student st) throws SQLException {
		String sql = "update student set sname=?,ssex=?,spw=?,sclass=? where sno=?";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(5, st.getSno());
		pst.setString(1, st.getSname());
		pst.setString(2, st.getSsex());
		pst.setString(3, st.getSpw());
		pst.setString(4, st.getSclass());
		pst.execute();
	}
}
