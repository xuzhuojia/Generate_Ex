package beans;

//题库表
public class Questions {

	private String qno;// 题号
	private int qtype;// 题目类型
	private int qvalue;// 分值
	private String qcontent;// 题目内容

	public Questions() {

	}

	public String getQno() {
		return qno;
	}

	public void setQno(String qno) {
		this.qno = qno;
	}

	public int getQtype() {
		return qtype;
	}

	public void setQtype(int qtype) {
		this.qtype = qtype;
	}

	public int getQvalue() {
		return qvalue;
	}

	public void setQvalue(int qvalue) {
		this.qvalue = qvalue;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

}
