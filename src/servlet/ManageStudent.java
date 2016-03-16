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
import db.dao.StudentDao;

public class ManageStudent extends HttpServlet {

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
		StudentDao studentDao = new StudentDao();
		List<Student> students = null;
		if (req.getParameter("submit").equals("查询")) {
			String s = req.getParameter("stu");
			if (teacher == null) {
				System.out.println("老师空");
			}
			try {
				if (teacher.getTclass().equals("全部")) {
					students = studentDao.query();// 教务员查询所有班级的学生
				} else {
					students = studentDao.getStudents(teacher.getTclass());// 老师只能查找指定班级的学生
				}
				if (students.size() == 0) {
					System.out.println("学生空");
				}
				System.out.println(s);
				int work = 0;
				for (Student student : students) {
					if (s.equals(student.getSname())) {
						out.println("<h3>学生" + s + "的信息如下</h3>");
						out.println("学号：" + student.getSno() + "<br>");
						out.println("姓名：" + student.getSname() + "<br>");
						out.println("性别：" + student.getSsex() + "<br>");
						out.println("班级：" + student.getSclass() + "<br>");
						work = 1;
						break;
					}
					if (s.equals(student.getSno())) {
						out.println("<h3>学生" + s + "的信息如下</h3>");
						out.println("学号：" + student.getSno() + "<br>");
						out.println("姓名：" + student.getSname() + "<br>");
						out.println("性别：" + student.getSsex() + "<br>");
						out.println("班级：" + student.getSclass() + "<br>");
						work = 1;
						break;
					}

				}
				if (work == 0) {
					for (Student student : students) {
						out.println("<h3>学生" + s + "的信息如下</h3>");
						out.println("学号：" + student.getSno() + "<br>");
						out.println("姓名：" + student.getSname() + "<br>");
						out.println("性别：" + student.getSsex() + "<br>");
						out.println("班级：" + student.getSclass() + "<br>");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (req.getParameter("submit").equals("增加学生")) {

			String psw = "123456";
			Student student = new Student();
			String sno = req.getParameter("sno");
			try {
				student = studentDao.getStudent(sno);
				if (!teacher.getTclass().equals("全部")) {
					if (student!= null) {
						student.setSno(sno);
						student.setSname(studentDao.getStudent(sno).getSname());
						student.setSclass(teacher.getTclass());
						student.setSsex(studentDao.getStudent(sno).getSsex());
						student.setSpw(psw);
						studentDao.update(student);// 老师把学生添进他所教的班级
						out.println("学生"
								+ studentDao.getStudent(sno).getSname()
								+ "已成功添加进您所教的班级：" + teacher.getTclass());
					} else {
						out.println("您不能直接从数据库增加学生！");// 老师不能直接添加学生
					}
				} else {// 教务员直接增加学生
					if (student== null) {
						Student student2 = new Student();
						student2.setSno(sno);
						student2.setSname(req.getParameter("sname"));
						student2.setSsex(req.getParameter("ssex"));
						student2.setSpw(psw);
						studentDao.add(student2);
					} else {
						out.println("该学生已存在！");
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (req.getParameter("submit").equals("删除")) {
			String psw = "123456";
			Student student = new Student();
			String sno = req.getParameter("sno");
			
			try {
				student = studentDao.getStudent(sno);
				if (!teacher.getTclass().equals("全部")) {
					if (student!= null
							&&teacher.getTclass().equals(student.getSclass())) {
						student.setSno(req.getParameter("sno"));
						student.setSname(studentDao.getStudent(sno).getSname());
						student.setSclass(null);// 老师把学生移出他所教的班级
						student.setSsex(studentDao.getStudent(sno).getSsex());
						student.setSpw(psw);
						studentDao.update(student);
						out.println("学生"
								+ studentDao.getStudent(sno).getSname()
								+ "已成功移出您所教的班级：" + teacher.getTclass());
					} else {
						out.println("您的班级本来就不存在这个学生！");// 老师不能直接添加学生
					}
				} else {// 教务员直接删除学生
					studentDao.del(sno);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (req.getParameter("submit").equals("修改学生信息")) {
			String psw = "123456";
			Student student = new Student();
			String sno = req.getParameter("sno");
			try {
				student = studentDao.getStudent(sno);
				if (!teacher.getTclass().equals("全部")) {
					if (student!= null
							&&teacher.getTclass().equals(student.getSclass())) {
						student.setSno(req.getParameter("sno"));
						student.setSname(req.getParameter("sname"));
						student.setSclass(teacher.getTclass());
						student.setSsex(req.getParameter("ssex"));
						student.setSpw(psw);
						studentDao.update(student);
						out.println("成功修改学生"+student.getSname()+"的信息");
					} else {
						out.println("您的班级不存在这个学生！");
					}
				} else {
					if (student != null) {
						student.setSno(req.getParameter("sno"));
						student.setSname(req.getParameter("sname"));
						student.setSsex(req.getParameter("ssex"));
						student.setSpw(psw);
						studentDao.update(student);
						out.println("成功修改学生"+student.getSname()+"的信息");
					} else {
						out.println("数据库不存在这个学生！");
					}
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
