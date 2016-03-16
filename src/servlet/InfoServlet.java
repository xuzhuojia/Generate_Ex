package servlet;
/**
 * 处理用户登录
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SE;
import beans.Student;
import beans.Teacher;
import db.dao.StudentDao;
import db.dao.TeacherDao;

public class InfoServlet extends HttpServlet {
	
	private String sno;
	private String spw;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSpw() {
		return spw;
	}

	public void setSpw(String spw) {
		this.spw = spw;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() 开始处理表单...");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		sno=req.getParameter("sno");
		spw=req.getParameter("spw");
		
		StudentDao std=new StudentDao();
		TeacherDao td=new TeacherDao();
		try {
			Student student=null;
			List<Student> students=null;
			Teacher teacher=null;
			List<Teacher> teachers=null;
			students=std.query();
			teachers=td.query();
			for ( Student student2 : students) {
				if(student2.getSno().equals(sno)){//如果存在该学号
					if(student2.getSpw().equals(spw)){//如果密码匹配
						student=std.getStudent(sno);//取出对应的对象
						break;
					}
					break;
				}
			}
			if(student!=null){//信息相符
				    req.getSession().setAttribute("student", student);
					req.getRequestDispatcher("../Srequest.jsp").forward(req, resp);//转发
			///////////
//					String eno;
//					eno=(String) req.getSession().getAttribute("eno");
//					SE se=new SE();
//					se.setEno(eno);
//					se.setSno(sno);
//		
//					if(se.getScore()!=0){
//					
//						req.getSession().setAttribute("se", se);
//						req.getRequestDispatcher("/SScoreQuery.jsp").forward(req, resp);//转发
//					}
//					else
//						se.setScore(0);
//					req.getSession().setAttribute("se", se);
//					req.getRequestDispatcher("/SScoreQuery.jsp").forward(req, resp);//转发
					
					///////////
			}
			else{//信息不相符
				//在教师表寻找
				for ( Teacher teacher2 : teachers) {
					if(teacher2.getTno().equals(sno)){//如果存在该学号
						if(teacher2.getTpw().equals(spw)){//如果密码匹配
							teacher=td.getTeacher(sno);//取出对应的对象
							break;
						}
						break;
					}
				}
				if(teacher!=null){//信息相符
					req.getSession().setAttribute("teacher", teacher);//保存对象到request
					if(teacher.getTclass().equals("全部")){
						req.getRequestDispatcher("../Drequest.jsp").forward(req, resp);//转发
					}else{
						req.getRequestDispatcher("../Trequest.jsp").forward(req, resp);//转发
					}
			     }else{
			    	 req.getRequestDispatcher("../relogin.jsp").forward(req, resp);//转发
			     }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.toString());
		}
		//resp.sendRedirect(req.getContextPath()+"/request.jsp");
		//resp.sendRedirect("../request.jsp");
		//out.println("MyServlet Web应用");
	}
	

}
