package beans;

//����
public class Questions {

	private String qno;// ���
	private int qtype;// ��Ŀ����
	private int qvalue;// ��ֵ
	private String qcontent;// ��Ŀ����

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
