package DataTransferObjectLib.PegawaiSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TableJobDto implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	private String jid;
	private String jobDesk;
	private BigDecimal gaji;
	
	 private String projekCode;
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public String getJobDesk() {
		return jobDesk;
	}
	public void setJobDesk(String jobDesk) {
		this.jobDesk = jobDesk;
	}
	public BigDecimal getGaji() {
		return gaji;
	}
	public void setGaji(BigDecimal gaji) {
		this.gaji = gaji;
	}
}
