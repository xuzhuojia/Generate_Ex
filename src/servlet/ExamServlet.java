package servlet;

/**
 * 生成试题
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Exam;
import beans.Paper;
import beans.Questions;
import db.dao.ExamDao;
import db.dao.PaperDao;
import db.dao.QuestionsDao;

public class ExamServlet extends HttpServlet {

	private int rad;// 试题中选择题个数
	private int blank;// 试题中填空题个数
	private int sim;// 试题中简答题个数
	private final int RAD=30;// 试题中选择题个数
	private final int BLANK=48;// 试题中填空题个数
	private final int SIM=45;// 试题中简答题个数
	private String eno;
	private Date startTime;
	private Date endTime;
	private PaperDao paperDao = new PaperDao();
	// qno有4位数，最高位标志题型
	private final int radnum = 1000;// 选择题标志
	private final int blanknum = 2000;// 填空题标志
	private final int simnum = 3000;// 简答题标志

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public int getBlank() {
		return blank;
	}

	public void setBlank(int blank) {
		this.blank = blank;
	}

	public int getSim() {
		return sim;
	}

	public void setSim(int sim) {
		this.sim = sim;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	// 随机生成选择题编号
	private String generRad() {

		int i = radnum + (int) (Math.random() * (RAD - 1)) + 1;
		return String.valueOf(i);
	}

	// 随机生成填空题编号
	private String generBlank() {
		int i = blanknum + (int) (Math.random() * (BLANK - 1)) + 1;
		return String.valueOf(i);
	}

	// 随机生成简答题编号
	private String generSim() {
		int i = simnum + (int) (Math.random() * (SIM - 1)) + 1;
		return String.valueOf(i);
	}

	// 随机生成试卷
	public void generExam() throws SQLException {
		List<String> qnoList=new ArrayList<String>();
		String w=null;
		for (int i = 0; i < rad; i++) {
			Paper paper = new Paper();
			paper.setEno(eno);
			w=generRad();
			while(qnoList.contains(w))
			{
				w=generRad();
			}
			System.out.println(w);
			qnoList.add(w);
			paper.setQno(w);
			paperDao.add(paper);
		}
		for (int i = 0; i < blank; i++) {
			Paper paper = new Paper();
			paper.setEno(eno);
			w=generBlank();
			while(qnoList.contains(w))
			{
				w=generBlank();
			}
			qnoList.add(w);
			paper.setQno(w);
			paperDao.add(paper);
		}
		for (int i = 0; i < sim; i++) {
			Paper paper = new Paper();
			paper.setEno(eno);
			w=generSim();
			while(qnoList.contains(w))
			{
				w=generSim();
			}
			qnoList.add(w);
			paper.setQno(w);
			paperDao.add(paper);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	// 老师用post方式提交生成试卷的申请
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 系统为这个请求生成试卷
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
				rad = 20;
				blank = 10;
				sim = 8;
				eno = req.getParameter("eno");
				Date date=new Date();
				date.setHours(2);
				Exam exam = new Exam();
				ExamDao examDao = new ExamDao();
				exam.setEno(eno);
				exam.setStartTime(sdf.format(new Date()));
				exam.setEndTime(sdf.format(date));
				try {
					out.println("add");
					examDao.add(exam);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					generExam();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("ok");
				List<Paper> paperOk = new ArrayList<Paper>();
				Questions question = new Questions();
				QuestionsDao qd = new QuestionsDao();
				try {
					out.println("新建试卷编号:" + eno + "<br>");
					paperOk = paperDao.getPaper(eno);
					out.println("<h2>一、选择题</h2><br>");
					for (Paper q : paperOk) {
						question = qd.getQuestion(q.getQno());
						if (question.getQtype() == 1) {
							out.println("<p>" + question.getQcontent()
									+ "&nbsp;&nbsp;&nbsp[" + question.getQvalue()
									+ "]</p>");
						}
					}
					out.println("<h2>二、填空題</h2><br>");
					for (Paper q : paperOk) {
						question = qd.getQuestion(q.getQno());
						if (question.getQtype() == 2) {
							out.println("<p>" + question.getQcontent()
									+ "&nbsp;&nbsp;&nbsp[" + question.getQvalue()
									+ "]</p>");
						}
					}
					out.println("<h2>三、简答题</h2><br>");
					for (Paper q : paperOk) {
						question = qd.getQuestion(q.getQno());
						if (question.getQtype() == 3) {
							out.println("<p>" + question.getQcontent()
									+ "&nbsp;&nbsp;&nbsp[" + question.getQvalue()
									+ "]</p>");
						}
					}
					req.getSession().setAttribute("eno", eno);
					out.println("<form action=\"DelExam\" method=\"post\">"
							+ "<input type=\"submit\" name=\"submit\" value=\"不想要这张卷子\"/> "
							+ "</form>");

					out.println("<form action=\"../exam.jsp\" method=\"post\">"
							+ "<input type=\"submit\" name=\"submit\" value=\"发布这张卷子\"/> "
							+ "</form>");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
