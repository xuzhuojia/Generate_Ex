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

//ִ�����ݿ�Ĳ顢ɾ����ӡ����²���
public class StudentDao {
	// ������ѯ
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

	// ѧ�������룬���Ը���ѧ�Ų�ѯ
	public Student getStudent(String sno) throws SQLException {

		String sql = "select * from student where sno=?;";
		Connection conn = DBHelper.getDbConn();
		Student student = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sno);
		ResultSet rst = pst.executeQuery();
		while (rst.next()) {// ѧ�Ų���Ӧʱ����studentΪnull
			student = new Student();
			student.setSno(rst.getString("sno"));
			student.setSname(rst.getString("sname"));
			student.setSsex(rst.getString("ssex"));
			student.setSpw(rst.getString("spw"));
			student.setSclass(rst.getString("sclass"));
		}
		return student;// ����֮��ĺ�������-----��Ҫ�ж��Ƿ�ΪnullȻ�������û�
	}

	// ���Ը��ݰ༶������ѯ
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
		return students;// ����֮��ĺ�������-----��Ҫ�ж��Ƿ�ΪnullȻ�������û�
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

	// û�ж�Ӧenoʱ���ݿⲻ�ᱨ�����������student=null
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
