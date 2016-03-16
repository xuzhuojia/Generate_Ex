package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.dao.ExamDao;
import db.dao.PaperDao;
import db.dao.SQDao;

public class DelExam extends HttpServlet {

	private String eno1;
	private String eno2;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		eno1 = (String) req.getSession().getAttribute("eno");
		System.out.println("sasasasas");
		eno2 = req.getParameter("eno");
		if (eno2 == null) {
			PaperDao paperDao = new PaperDao();
			SQDao sqDao=new SQDao();
			ExamDao examDao = new ExamDao();
			try {
				sqDao.del2(eno1);
				paperDao.del(eno1);
				examDao.del(eno1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			PaperDao paperDao = new PaperDao();
			SQDao sqDao=new SQDao();
			ExamDao examDao = new ExamDao();
			try {
				sqDao.del2(eno2);
				paperDao.del(eno2);
				examDao.del(eno2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		req.getRequestDispatcher("../Trequest.jsp").forward(req, resp);
	}

}
