package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
/**
 * 管理题库
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Questions;
import beans.RightAnswer;
import db.dao.QuestionsDao;
import db.dao.RightAnswerDao;

public class ManageQue extends HttpServlet {
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Questions question=new Questions();
		QuestionsDao questionsDao=new QuestionsDao();
		RightAnswer rightAnswer=new RightAnswer();
		RightAnswerDao rightAnswerDao=new RightAnswerDao();
		if(req.getParameter("submit").equals("查看所有试题")){
			
			List<Questions> questions;
			try {
				questions = questionsDao.query();
				for (Questions questions2 : questions) {
					out.println("<"+questions2.getQno()+"> "+questions2.getQcontent()+"["+questions2.getQvalue()+"]<br>");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(req.getParameter("submit").equals("增加题目")){
			List<Questions> questions;
			try {
				questions = questionsDao.query();
				int type=Integer.parseInt(req.getParameter("qtype"));
				List<String> qnos=new ArrayList<String>();
				for (Questions questions2 : questions) {
					qnos.add(questions2.getQno());
				}
				String qno=String.valueOf(type*1000+(int) (Math.random() * (999 - 1)) + 1);
				while(qnos.contains(qno)){
					qno=String.valueOf(type*1000+(int) (Math.random() * (999 - 1)) + 1);
				}
				System.out.println(qno);
				question.setQno(qno);
				question.setQtype(type);
				if(type==1||type==2){
					question.setQvalue(2);
				}else{
					question.setQvalue(5);
				}
				question.setQcontent(req.getParameter("qcontent"));
				rightAnswer.setQno(qno);
				rightAnswer.setQanswer(req.getParameter("qanswer"));
					questionsDao.add(question);
					rightAnswerDao.add(rightAnswer);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(req.getParameter("submit").equals("删除")){
			try {
				rightAnswerDao.del(req.getParameter("qno"));
				questionsDao.del(req.getParameter("qno"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
