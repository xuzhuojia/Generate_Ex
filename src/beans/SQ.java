package beans;

//ѧ���Ծ��
public class SQ {

	private String sno;// ѧ��[����,����]
	private String eno;// ���Ա��[���룬����]
	private String qno;// ���[����,����]
	private String sanswer;// �����
	private int qscore;// ����÷�

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
