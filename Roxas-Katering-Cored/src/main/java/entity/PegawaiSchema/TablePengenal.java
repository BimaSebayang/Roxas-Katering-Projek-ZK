package entity.PegawaiSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.PegawaiSchema.entityPegawaiPk.TablePengenalPk;

@Entity
@Table(name="PEGAWAI.TABLE_PENGENAL")
@IdClass(TablePengenalPk.class)
public class TablePengenal {
	private String pegawaiId;
    private String jid;
    private String roleId;
	private Integer status;
	 private String projekCode;
     
	    @Column(name = "PROJEK_CODE")
	    public String getProjekCode() {
			return projekCode;
		}
		public void setProjekCode(String projekCode) {
			this.projekCode = projekCode;
		}
    
   

	 @Id
	  @Column(name="PEGAWAI_ID")
	 public String getPegawaiId() {
		return pegawaiId;
	}
	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
	}
	@Column(name="JID") 
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}  
    @Column(name="ROLE_ID")
    public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	 @Column(name="STATUS")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
