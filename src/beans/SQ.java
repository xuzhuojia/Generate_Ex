package beans;

//学生试卷表
public class SQ {

	private String sno;// 学号[外码,主码]
	private String eno;// 考试编号[外码，主码]
	private String qno;// 题号[外码,主码]
	private String sanswer;// 该题答案
	private int qscore;// 该题得分

	public SQ() {

	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getQno() {
		return qno;
	}

	public void setQno(String qno) {
		this.qno = qno;
	}

	public String getSanswer() {
		return sanswer;
	}

	public void setSanswer(String sanswer) {
		this.sanswer = sanswer;
	}

	public int getQscore() {
		return qscore;
	}

	public void setQscore(int qscore) {
		this.qscore = qscore;
	}

}
