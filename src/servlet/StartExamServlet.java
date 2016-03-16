package servlet;
/**
 * 学生做试卷
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

import beans.Paper;
import beans.Questions;
import beans.Student;
import db.dao.PaperDao;
import db.dao.QuestionsDao;

public class StartExamServlet extends HttpServlet {

	private String eno;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 系统为这个请求生成试卷
		//eno="406";//后期要求学生自己输入
		eno=req.getParameter("eno");//后期要求学生自己输入
		System.out.println(eno);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		System.out.println("ok");
		List<Paper> paperOk = new ArrayList<Paper>();
		Questions question = new Questions();
		QuestionsDao qd = new QuestionsDao();
		PaperDao paperDao=new PaperDao();
		out.println("<form action=\"Submit\" method=\"post\">");
		try {
			
			out.println("<div style=\"font-size:18px;\">考试是 "+req.getParameter("title")+" ，考试时间为60分钟，考试编号为["+eno+ "]</div><br>");
			out.println("<div style=\"padding-left:40px;\">");
			paperOk = paperDao.getPaper(eno);
			out.println("<h2>一、选择题</h2><br>");
			for (Paper q : paperOk) {
				question = qd.getQuestion(q.getQno());
				if (question.getQtype() == 1) {
					String s=question.getQcontent();
					String[] ss=s.split("<br>");
					out.println("<p>题目：" + ss[0]
							+ "&nbsp;&nbsp;&nbsp[" + question.getQvalue()
							+ "]</p>");
					out.println("<div style=\"padding-left:50px;\">");
					for(int i=1;i<ss.length;i++){
						out.println(" <input type=\"radio\" name=\""+q.getQno()+"\" value='"+ss[i].charAt(0)+"'/>"+ss[i]+"<br>");
					}
					out.println("</div>");
				}
			}
			out.println("<h2>二、填空題</h2><br>");
			for (Paper q : paperOk) {
				question = qd.getQuestion(q.getQno());
				if (question.getQtype() == 2) {
					out.println("<p>题目：" + question.getQcontent()
							+ "&nbsp;&nbsp;[" + question.getQvalue()
							+ "]</p>");
					out.println("<div style=\"padding-left:60px;\">");
					out.println("<input style=\"font-size:18px;\" type=\"text\" name=\""+q.getQno()+"\" /><br>");
					out.println("</div>");
				}
			}
			out.println("<h2>三、简答题</h2><br>");
			for (Paper q : paperOk) {
				question = qd.getQuestion(q.getQno());
				if (question.getQtype() == 3) {
					out.println("<p>题目：" + question.getQcontent()
							+ "&nbsp;&nbsp;[" + question.getQvalue()
							+ "]</p>");
					out.println("<div style=\"padding-left:50px;\">");
					out.println("<textarea style=\"font-size:18px;\"name=\""+q.getQno()+"\" cols=100 rows=10 id='comment' tabindex='4'>答：</textarea><br>");
					out.println("</div>");
				}
			}
			req.getSession().setAttribute("eno", eno);
			out.println("<input type=\"submit\" name=\"submit\" value=\"交卷\" />");
			out.println("</form>");
			out.println("</div>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 老师用post方式提交生成试卷的申请
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

}
