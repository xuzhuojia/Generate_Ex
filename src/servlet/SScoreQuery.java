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

public class SScoreQuery extends HttpServlet {

	private String tno;
	private String tclass;
	private String eno;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
//		eno="006";
//		Teacher teacher=new Teacher();
//		//TeacherDao teacherDao=new TeacherDao();
//		teacher=(Teacher) req.getSession().getAttribute("teacher");
//		tclass=teacher.getTclass();
//		StudentDao studentDao=new StudentDao();
//		List<String> snos=new ArrayList<String>();//存储指定班级里的学号
//		try {
//			List<Student> students=studentDao.getStudents(tclass);
//			for (Student student : students) {
//				snos.add(student.getSno());
//			}
//			SQDao sqd=new SQDao();
//			QuestionsDao qsd=new QuestionsDao();
//			RightAnswerDao rightAnswerd=new RightAnswerDao();
//			List<SQ> sqs=new ArrayList<SQ>();
//			req.getSession().setAttribute("snos", snos);
//			req.getSession().setAttribute("eno", eno);
//			for (String sno : snos) {
//				sqs=sqd.getSQ(sno, eno);
//				if(sqs!=null&&sqs.size()>0){
//					out.println("<h3>学号为"+sno+"的学生的答题如下：</h3>");
//				}
//				req.getSession().setAttribute("sqs"+sno, sqs);
//				for (SQ sq : sqs) {
//					int type=qsd.getQuestion(sq.getQno()).getQtype();
//					if(type==1){//是选择题
//						if(!sq.getSanswer().equals(rightAnswerd.getRightAnswer(sq.getQno()).getQanswer())
//								||sq.getSanswer()==null){//如果答案和标准答案不一样或者答案为空
//							sq.setQscore(0);
//							sqd.update(sq);
//						}else{//否则给2分
//							sq.setQscore(2);
//							sqd.update(sq);
//						}
//					}else{
//						out.println("<form action=\"CheckScore\" method=\"post\">");
//						if(type==2){
//						out.println("答：  "+sq.getSanswer()+"<br>");
//						out.println("标准答案为： "+rightAnswerd.getRightAnswer(sq.getQno()).getQanswer());
//						out.println("【满分2分】<br>");
//						out.println("请给分<input type=\"text\" name=\""+sno+sq.getQno()+"\" /><br>");
//						}else{
//							out.println("答：  "+sq.getSanswer()+"<br>");
//							out.println("标准答案为： "+rightAnswerd.getRightAnswer(sq.getQno()).getQanswer());
//							out.println("【满分5分】<br>");
//							out.println("请给分<input type=\"text\" name=\""+sno+sq.getQno()+"\" /><br>");
//						}
//					}
//				}
//			}
			//out.println("<input type=\"submit\" name=\"submit\" value=\"提交!!\" />");
			out.println("<input type=\"submit\" name=\"submit\" value=\"提交\" />");
			out.println("</form>");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			out.println("eeeeeeeeeeeee");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
