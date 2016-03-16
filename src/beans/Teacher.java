package beans;

//老师信息表
public class Teacher {

	private String tno;// 教师编号
	private String tname;// 姓名
	private String tsex;// 性别
	private String tpw;// 密码
	private String tclass;// 所教班级

	public Teacher() {

	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public String getTpw() {
		return tpw;
	}

	public void setTpw(String tpw) {
		this.tpw = tpw;
	}

	public String getTclass() {
		return tclass;
	}

	public void setTclass(String tclass) {
		this.tclass = tclass;
	}

}
