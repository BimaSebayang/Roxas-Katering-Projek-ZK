package entity.MassageSchema;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.MassageSchema.entityMessagePk.TablePersonApprovalHdrPk;

@Entity
@Table(name="MESSAGE.TABLE_PERSON_APPROVAL_HDR")
@IdClass(TablePersonApprovalHdrPk.class)
public class TablePersonApprovalHdr  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String formatApprovalId;
	private String menuCode;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private Integer statusAktif;
	private String approvalStatus;
	private String urlMenuApproval;
	
	@Column(name="URL_MENU_APPROVAL")
	public String getUrlMenuApproval() {
		return urlMenuApproval;
	}
	public void setUrlMenuApproval(String urlMenuApproval) {
		this.urlMenuApproval = urlMenuApproval;
	}
	
	
	@Id
	@Column(name="FORMAT_APPROVAL_ID")
	public String getFormatApprovalId() {
		return formatApprovalId;
	}
	public void setFormatApprovalId(String formatApprovalId) {
		this.formatApprovalId = formatApprovalId;
	}
	
	@Column(name="MENU_CODE")
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name="STATUS_AKTIF")
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
	}
	
	@Column(name="APPROVAL_STATUS")
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	
	
}
