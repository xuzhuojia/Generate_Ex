package beans;

import java.util.Date;


public class Notice {
	private String tno;
	private Date ntime;
	private String ntitle;
	private String ncontent;
	private String eno;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}

	
	public Date getNtime() {
		return ntime;
	}
	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	

}
