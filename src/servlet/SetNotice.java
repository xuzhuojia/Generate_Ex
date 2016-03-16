package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Notice;
import db.dao.NoticeDao;

public class SetNotice extends HttpServlet {
	private String s = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	// ��ù���浽��ݿ�
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		s = (String) req.getParameter("eno");
		NoticeDao noticeDao = new NoticeDao();
		if (s != null) {
			System.out.println(s);
			Notice notice = new Notice();
			String tno = String.valueOf((int) (Math.random() * 10000) + 1);
			try {
				notice = noticeDao.getNotice(tno);
				while (notice != null) {
					tno = String.valueOf((int) (Math.random() * 10000) + 1);
					notice = noticeDao.getNotice(tno);
				}
				notice = new Notice();
				notice.setTno(tno);
				notice.setNtime(new Date());
				if(req.getParameter("ntitle")==null||req.getParameter("ncontent")==null){
					return;
				}
				notice.setNtitle(req.getParameter("ntitle"));
				notice.setNcontent(req.getParameter("ncontent"));
				notice.setEno(s);
				noticeDao.add(notice);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println(s);
			Notice notice = new Notice();
			String tno = String.valueOf((int) (Math.random() * 10000) + 1);
			try {
				notice = noticeDao.getNotice(tno);
				while (notice != null) {
					tno = String.valueOf((int) (Math.random() * 10000) + 1);
					notice = noticeDao.getNotice(tno);
				}
				notice = new Notice();
				notice.setTno(tno);
				notice.setNtime(new Date());
				notice.setNtitle(req.getParameter("ntitle"));
				notice.setNcontent(req.getParameter("ncontent"));
				notice.setEno(null);
				noticeDao.add(notice);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
       req.getRequestDispatcher("../Trequest.jsp").forward(req, resp);;
	}
}
