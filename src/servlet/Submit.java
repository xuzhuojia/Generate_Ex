package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Paper;
import beans.SE;
import beans.SQ;
import beans.Student;
import db.dao.PaperDao;
import db.dao.SEDao;
import db.dao.SQDao;

public class Submit extends HttpServlet {

	private String eno;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		System.out.println("89898");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<Paper> paperOk = new ArrayList<Paper>();
		PaperDao paperDao=new PaperDao();
		eno=(String) req.getSession().getAttribute("eno");
		Student student=new Student();
		SQ sq=new SQ();
		SQDao sqd=new SQDao();
		student=(Student) req.getSession().getAttribute("student");
			
			try {
				paperOk = paperDao.getPaper(eno);
				for (Paper paper : paperOk) {
					String answer=req.getParameter(paper.getQno());
					sq.setEno(eno);
					sq.setSno(student.getSno());
					sq.setQno(paper.getQno());
					sq.setSanswer(answer);
					sqd.add(sq);
					
				}
				SE se=new SE();
				SEDao seDao =new SEDao();
				se.setEno(eno);
				se.setSno(student.getSno());
				seDao.add(se);
				out.println("试卷编号为:" + eno + "已提交<br>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
