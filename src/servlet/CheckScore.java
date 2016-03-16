package servlet;
/**
 * 录入学生成绩
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SE;
import beans.SQ;
import db.dao.SEDao;
import db.dao.SQDao;

public class CheckScore extends HttpServlet {

	private String eno;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		List<String> snos=new ArrayList<String>();
		List<SQ> sqs=new ArrayList<SQ>();
		SQDao sqd=new SQDao();
		SEDao sed=new SEDao();
		snos=(List<String>) req.getSession().getAttribute("snos");
		eno=(String) req.getSession().getAttribute("eno");
		System.out.println(eno);
		for (String sno : snos) {
			sqs=(List<SQ>) req.getSession().getAttribute("sqs"+sno);
			for (SQ sq : sqs) {
				if(sq.getSno().equals(sno)){
					if(req.getParameter(sno+sq.getQno())!=null){
					int score=Integer.parseInt(req.getParameter(sno+sq.getQno()));
					sq.setQscore(score);
			
					try {
						sqd.update(sq);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					}
				}
			}
			try {
				List<SQ> sqqs=sqd.getSQ(sno, eno);
				int grade=0;
				for (SQ sq : sqqs) {
					grade+=sq.getQscore();
				}
				SE se=new SE();
				se.setEno(eno);
				se.setSno(sno);
				se.setScore(grade);
				sed.update(se);
//				///////////
//				if(se.getScore()!=0){
//				
//					req.getSession().setAttribute("se", se);
//					req.getRequestDispatcher("SScoreQuery.jsp").forward(req, resp);//转发
//				}
//				else
//					se.setScore(0);
//				req.getSession().setAttribute("se", se);
//				req.getRequestDispatcher("SScoreQuery.jsp").forward(req, resp);//转发
//				
//				///////////
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
