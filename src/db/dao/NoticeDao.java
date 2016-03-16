package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Notice;
import db.DBHelper;

//执行数据库的查、删、添加、更新操作
public class NoticeDao {
	// 批量查询
	public List<Notice> query() throws SQLException {

		List<Notice> notices = new ArrayList<Notice>();
		String sql = "select * from notice;";
		Connection conn = DBHelper.getDbConn();
		Statement stm = (Statement) conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			Notice notice = new Notice();
			notice.setTno(rst.getString("tno"));
			notice.setNtime(new java.util.Date(rst.getDate("ntime").getTime()));
			notice.setNtitle(rst.getString("ntitle"));
			notice.setNcontent(rst.getString("ncontent"));
			notice.setEno(rst.getString("eno"));
			notices.add(notice);
		}
		return notices;
	}

	// 学号是主码，可以根据学号查询
	public Notice getNotice(String tno) throws SQLException {

		String sql = "select * from notice where tno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, tno);
		ResultSet rst = pst.executeQuery();
		Notice notice=null;
		while (rst.next()) {// 学号不对应时会让exam为null
			 notice= new Notice();
			notice.setTno(rst.getString("tno"));
			notice.setNtime(new Date(rst.getDate("ntime").getTime()));
			notice.setNtitle(rst.getString("ntitle"));
			notice.setNcontent(rst.getString("ncontent"));
			notice.setTno(rst.getString("eno"));
		}
		return notice;// 返回之后的后续处理-----需要判断是否为null然后反馈给用户
	}

	public void del(String tno) throws SQLException {
		String sql = "delete from notice where tno=?;";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, tno);
		pst.execute();
	}

	public void add(Notice n) throws SQLException {
		String sql = "insert into notice(tno,ntime,ntitle,ncontent,eno) values(?,?,?,?,?);";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, n.getTno());
		pst.setDate(2, new java.sql.Date(n.getNtime().getTime()));
		pst.setString(3, n.getNtitle());
		pst.setString(4, n.getNcontent());
		pst.setString(5, n.getEno());
		pst.execute();
	}

	// 没有对应eno时数据库不会报错，但这里会让exam=null
	public void update(Notice n) throws SQLException {
		String sql = "update notice set ntime=?,ntitle=?,ncontent=?,eno=? where tno=?";
		Connection conn = DBHelper.getDbConn();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(4, n.getEno());
		pst.setString(2, n.getNtitle());
		pst.setDate(1, new java.sql.Date(n.getNtime().getTime()));
		pst.setString(3, n.getNcontent());
		pst.setString(5, n.getTno());
		pst.execute();
		pst.close();
	}
}
