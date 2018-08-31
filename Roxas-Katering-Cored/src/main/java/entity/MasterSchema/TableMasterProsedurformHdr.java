package entity.MasterSchema;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.MasterSchema.entityMasterPk.TableMasterProsedurformHdrPk;

@Entity
@Table(name = "MASTER.TABLE_MASTER_PROSEDURFORM_HDR")
@IdClass(TableMasterProsedurformHdrPk.class)
public class TableMasterProsedurformHdr {
	private String prosedurId;
	private String prosedurName;
	private String menuCode;
	private Integer totalProsedur;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private Integer statusAktif;
    private String statusApproval;
    private String projekCode;
    
    @Id
	@Column(name = "PROSEDUR_ID")
	public String getProsedurId() {
		return prosedurId;
	}
	public void setProsedurId(String prosedurId) {
		this.prosedurId = prosedurId;
	}
	@Column(name = "PROSEDUR_NAME")
	public String getProsedurName() {
		return prosedurName;
	}
	public void setProsedurName(String prosedurName) {
		this.prosedurName = prosedurName;
	}
	@Column(name = "MENU_CODE")
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	
	@Column(name = "TOTAL_PROSEDUR")
	public Integer getTotalProsedur() {
		return totalProsedur;
	}
	public void setTotalProsedur(Integer totalProsedur) {
		this.totalProsedur = totalProsedur;
	}
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "STATUS_AKTIF")
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
	}
	
	@Column(name = "STATUS_APPROVAL")
	public String getStatusApproval() {
		return statusApproval;
	}
	public void setStatusApproval(String statusApproval) {
		this.statusApproval = statusApproval;
	}
    
	@Column(name = "PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}

	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
