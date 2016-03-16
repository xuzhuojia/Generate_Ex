package servlet;
/**
 * 学生查成绩
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import beans.Questions;
import beans.RightAnswer;
import beans.SE;
import beans.SQ;
import beans.Student;
import db.dao.QuestionsDao;
import db.dao.RightAnswerDao;
import db.dao.SEDao;
import db.dao.SQDao;

public class GetScore extends HttpServlet implements HttpSessionListener{

	private String  sno;
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	//学生点开链接要查成绩
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		 int n=0;
		System.out.println("doGet() 开始处理请求...");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		if(req.getSession()!=null){
		sno=((Student)req.getSession().getAttribute("student")).getSno();
		System.out.println(sno);
		SEDao sed=new SEDao();
		SQDao sqd=new SQDao();
		QuestionsDao qsd=new QuestionsDao();
		RightAnswerDao rad=new RightAnswerDao();
		List<SE> ses=new ArrayList<SE>();
		List<SQ> sqs=new ArrayList<SQ>();
		try {
			ses=sed.getSE(sno);
			
			out.println("<head><title>学生-成绩查询</title>");
			out.println("<link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />");
			out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />");
			out.println("</head>");
			
			out.println("<body style=\"background-color:#dcf2ff\">");
			out.println("<div style=\"text-align:center;font-size:22px;color:black\">");
			out.println("&nbsp;&nbsp;考试学号："+sno+"&nbsp;&nbsp;");
			out.println("</div>");
			
			for (SE se : ses) {
				if(se.getEno().equals(req.getParameter("eno"))){
					out.println("<div style=\"text-align:center;font-size:22px;color:black\">");
					out.println("考试编号："+se.getEno()+"&nbsp;&nbsp;成绩："+se.getScore()+"");
					out.println("</div><br>");	
				//out.println("<h2>考试编号: "+se.getEno()+"</h2><h2>成绩 ["+se.getScore()+"]</h2>");
				sqs=sqd.getSQ(sno, se.getEno());
				 for (SQ sq : sqs) {
//					n=n+1;
					Questions question=qsd.getQuestion(sq.getQno());
					RightAnswer ra=rad.getRightAnswer(sq.getQno());
					out.println("<div style=\"text-align:left;background-color:#fff;"
							+ "margin-right: 200px;margin-left: 200px;padding-top: 10px;padding-left:10px;font-size:18px;\">");
					out.println("题目："+question.getQcontent()+"<strong> 分值["+question.getQvalue()+"]</strong><br>");
					//out.println("<div style=\"text-align:right; \">");
					out.println("&nbsp;"+"您的得分："+sq.getQscore()+"<br>");
					out.println("&nbsp;"+"您的答案是："+sq.getSanswer()+"<br>");
					out.println("&nbsp;"+"标准答案是："+ra.getQanswer()+"<br>");
					//out.println("<div/>");
					out.println("<hr/>");
					out.println("</div>");
					
				}
				}
			
			}

			
			out.println("</body>");
			
			//out.println("<h2>考生学号:"+sno+"</h2>");
/*			for (SE se : ses) {
				if(se.getEno().equals(req.getParameter("eno"))){
				out.println("<h2>考试编号: "+se.getEno()+"</h2><h2>成绩 ["+se.getScore()+"]</h2>");
				sqs=sqd.getSQ(sno, se.getEno());
				 for (SQ sq : sqs) {
					Questions question=qsd.getQuestion(sq.getQno());
					RightAnswer ra=rad.getRightAnswer(sq.getQno());
					out.println(question.getQcontent()+" 分值["+question.getQvalue()+"]<br>");
					out.println("您的得分："+sq.getQscore()+"<br>");
					out.println("您的答案是："+sq.getSanswer()+"<br>");
					out.println("标准答案是："+ra.getQanswer()+"<br>");
				}
				}
			
			}*/
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("销毁了");
	}
}
