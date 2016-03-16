package beans;

//学生考试信息表
public class SE {

	private String sno;// 学号[主码]
	private String eno;// 考试编号[外码，主码]
	private String examState;// 考试状态
	private int score;// 考试成绩

	public SE() {

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

	public String getExamState() {
		return examState;
	}

	public void setExamState(String examState) {
		this.examState = examState;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
