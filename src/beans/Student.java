package beans;

//学生信息表
public class Student {
	private String sno;// 学号
	private String sname;// 姓名
	private String ssex;// 性别
	private String spw;// 密码
	private String sclass;// 班级

	public Student() {

	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSpw() {
		return spw;
	}

	public void setSpw(String spw) {
		this.spw = spw;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

}
