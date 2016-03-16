package servlet;
/**
 * 老师改成绩
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

import beans.SQ;
import beans.Student;
import beans.Teacher;
import db.dao.QuestionsDao;
import db.dao.RightAnswerDao;
import db.dao.SQDao;
import db.dao.StudentDao;

public class SetScore extends HttpServlet {

	private String tno;
	private String tclass;
	private String eno;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=resp.getWriter();
		eno="112";
		Teacher teacher=new Teacher();
		//TeacherDao teacherDao=new TeacherDao();
		teacher=(Teacher) req.getSession().getAttribute("teacher");
		tclass=teacher.getTclass();
		StudentDao studentDao=new StudentDao();
		List<String> snos=new ArrayList<String>();//存储指定班级里的学号
		out.println("<body style=\"background-color:#dcf2ff\">");
		try {
			List<Student> students=studentDao.getStudents(tclass);
			for (Student student : students) {
				snos.add(student.getSno());
			}
			SQDao sqd=new SQDao();
			QuestionsDao qsd=new QuestionsDao();
			RightAnswerDao rightAnswerd=new RightAnswerDao();
			List<SQ> sqs=new ArrayList<SQ>();
			req.getSession().setAttribute("snos", snos);
			req.getSession().setAttribute("eno", eno);
			
			for (String sno : snos) {
				sqs=sqd.getSQ(sno, eno);
				if(sqs!=null&&sqs.size()>0){
					out.println("<div style=\"text-align:center;font-size:22px;color:black\">");
					out.println("<h3>学生学号:"+sno+"</h3>");
					out.println("</div><strong style=\"margin-left:90px;font-size:22px;\">答题情况:</strong>");
				}
				req.getSession().setAttribute("sqs"+sno, sqs);
				for (SQ sq : sqs) {
					int type=qsd.getQuestion(sq.getQno()).getQtype();
					if(type==1){//是选择题
						if(sq.getSanswer()!=null){
						if(!sq.getSanswer().equals(rightAnswerd.getRightAnswer(sq.getQno()).getQanswer())
								||sq.getSanswer()==null){//如果答案和标准答案不一样或者答案为空
							sq.setQscore(0);
							sqd.update(sq);
						}else{//否则给2分
							sq.setQscore(2);
							sqd.update(sq);
						}
						}else{
							if(sq.getSanswer()==null){
								sq.setQscore(0);
								sqd.update(sq);
							}
						}
					}else{
						out.println("<div style=\"text-align:left;background-color:#fff;"
								+ "margin-right: 180px;margin-left: 180px;padding-top: 20px;padding-left:20px;font-size:18px;\">");
						out.println("<form action=\"CheckScore\" method=\"post\">");
						if(type==2){
							out.println("<div style=\"margin-top:10px;\">");
						out.println("考生答案为：  "+sq.getSanswer()+"<br>");
						out.println("</div><div style=\"margin-top:10px;\">");
						out.println("标准答案为： "+rightAnswerd.getRightAnswer(sq.getQno()).getQanswer());
						out.println("<br>");
						out.println("</div><div style=\"margin-top:10px;\">");
						out.println("请给分:&nbsp;<input value=\"0\" type=\"text\" name=\""+sno+sq.getQno()+"\" /><div style=\"text-align:right;padding-right:20px;\">【满分2分】</div><br>");
						out.println("</div>");
						}else{
							out.println("<div style=\"margin-top:10px;\">");
							out.println("考生答案为：  "+sq.getSanswer()+"<br>");
							out.println("</div><div style=\"margin-top:10px;\">");
							out.println("标准答案为： "+rightAnswerd.getRightAnswer(sq.getQno()).getQanswer());
							out.println("<br>");
							out.println("</div><div style=\"margin-top:10px;\">");
							out.println("请给分:&nbsp;<input value=\"0\" type=\"text\" name=\""+sno+sq.getQno()+"\" /><div style=\"text-align:right;padding-right:20px;\">【满分5分】</div><br>");
							out.println("</div>");
						}
					
						out.println("<hr width=100% size=2 color=#000 "
								+ "style=\"filter:progid:DXImageTransform.Microsoft.Shadow(color#5151A2,direction:145,strength:15)\">");
						out.println("</div>");
						
					}
				}
			}
			//out.println("<input type=\"submit\" name=\"submit\" value=\"提交!!\" />");
		//	out.println("<div style=\"float:right;\"");
			out.println("<input style=\"color: #d9eef7; border: solid 1px #0076a3;background: #0095cd; background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5)); "
					+ "background: -moz-linear-gradient(top, #00adee, #0078a5);font-size:22px; "
					+ "filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee', endColorstr='#0078a5');"
					+ "\" type=\"submit\" name=\"submit\" value=\"提交\" />");
			//out.println("</div>");
			out.println("</form>");
			out.println("</body>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
