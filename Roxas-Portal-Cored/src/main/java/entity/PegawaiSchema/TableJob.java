package entity.PegawaiSchema;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.PegawaiSchema.entityPegawaiPk.TableJobPk;

@Entity
@Table(name="PEGAWAI.TABLE_JOB")
@IdClass(TableJobPk.class)
public class TableJob {

		private String jid;
		private String jobDesk;
		private BigDecimal gaji;
		//public String tes;
		 private String projekCode;
	      
		    @Column(name = "PROJEK_CODE")
		    public String getProjekCode() {
				return projekCode;
			}
			public void setProjekCode(String projekCode) {
				this.projekCode = projekCode;
			}
		
		@Id
		@Column(name="JID")
		public String getJid() {
			return jid;
		}

		public void setJid(String jid) {
			this.jid = jid;
		}

		@Column(name="JOB_DESK")
		public String getJobDesk() {
			return jobDesk;
		}

		public void setJobDesk(String jobDesk) {
			this.jobDesk = jobDesk;
		}

		@Column(name="GAJI")
		public BigDecimal getGaji() {
			return gaji;
		}

		public void setGaji(BigDecimal gaji) {
			this.gaji = gaji;
		}
		
	@Override
	public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
	}
		
}
