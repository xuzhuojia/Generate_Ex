package beans;

//正确答案表
public class RightAnswer {

	private String qno;// 题号[主码、外码]
	private String qanswer;// 标准答案

	public RightAnswer() {

	}

	public String getQno() {
		return qno;
	}

	public void setQno(String qno) {
		this.qno = qno;
	}

	public String getQanswer() {
		return qanswer;
	}

	public void setQanswer(String qanswer) {
		this.qanswer = qanswer;
	}

}
