package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
/**
 * 管理学生
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import beans.Teacher;
import db.dao.TeacherDao;

public class ManageTeacher extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Teacher teacher = (Teacher) req.getSession().getAttribute("teacher");
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teachers = null;
		if (req.getParameter("submit").equals("查询")) {
			String s = req.getParameter("tea");
			try {
				teachers = teacherDao.query();
				System.out.println(s);
				int work=0;
				for (Teacher teacher2 : teachers) {
					System.out.println(teacher2.getTname());
					if (s.equals(teacher2.getTname())) {
						out.println("<h3>教师" + s + "的信息如下</h3>");
						out.println("教号：" + teacher2.getTno() + "<br>");
						out.println("姓名：" + teacher2.getTname() + "<br>");
						out.println("性别：" + teacher2.getTsex() + "<br>");
						out.println("所教班级：" + teacher2.getTclass() + "<br>");
						work=1;
						break;
					} 
					if (s.equals(teacher2.getTno())) {
						out.println("<h3>教师" + s + "的信息如下</h3>");
						out.println("教号：" + teacher.getTno() + "<br>");
						out.println("姓名：" + teacher.getTname() + "<br>");
						out.println("性别：" + teacher.getTsex() + "<br>");
						out.println("班级：" + teacher.getTclass() + "<br>");
						work = 1;
						break;
					}
				}
				if(work==0){
					for (Teacher teacher2 : teachers){
						out.println("<h3>教师" + s + "的信息如下</h3>");
						out.println("学号：" +  teacher2.getTno()  + "<br>");
						out.println("姓名：" +  teacher2.getTname() + "<br>");
						out.println("性别：" + teacher2.getTsex() + "<br>");
						out.println("所教班级：" + teacher2.getTclass() + "<br>");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (req.getParameter("submit").equals("增加教师")) {

			String psw = "123456";
			Teacher t=new Teacher();
			try {
					if (teacherDao.getTeacher(req.getParameter("tno")) == null) {
						t.setTno(req.getParameter("tno"));
						t.setTname(req.getParameter("tname"));
						t.setTclass(req.getParameter("tclass"));
						t.setTsex(req.getParameter("tsex"));
						t.setTpw(psw);
						teacherDao.add(t);
					}
					else{
						out.println("该教师已存在！");
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (req.getParameter("submit").equals("删除")) {
			String tno = req.getParameter("tno");
			try {
						teacherDao.del(tno);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (req.getParameter("submit").equals("修改教师信息")) {
			String psw = "123456";
			Teacher t=new Teacher();
			String tno = req.getParameter("tno");
			try {
					if (teacherDao.getTeacher(tno) != null) {
						t.setTno(req.getParameter("tno"));
						t.setTname(req.getParameter("tname"));
						t.setTclass(req.getParameter("tclass"));
						t.setTsex(req.getParameter("tsex"));
						t.setTpw(psw);
						teacherDao.update(t);
					} else {
						System.out.println(tno);
						out.println("不存在这个教师！");
					}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
	}

}
