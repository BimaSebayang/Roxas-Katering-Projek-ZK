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

import entity.MassageSchema.entityMessagePk.TablePersonApprovalDtlPk;

@Entity
@Table(name="MESSAGE.TABLE_PERSON_APPROVAL_DTL")
@IdClass(TablePersonApprovalDtlPk.class)
public class TablePersonApprovalDtl implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String trxIdDtl;
	private String formatApprovalId;
	private String personInCharge;
	private Integer approvalSequence;
	private Integer statusAktif;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updateDate;
	
	@Id
	@Column(name="TRX_ID_DTL")
	public String getTrxIdDtl() {
		return trxIdDtl;
	}
	public void setTrxIdDtl(String trxIdDtl) {
		this.trxIdDtl = trxIdDtl;
	}
	
	@Column(name="FORMAT_APPROVAL_ID")
	public String getFormatApprovalId() {
		return formatApprovalId;
	}
	public void setFormatApprovalId(String formatApprovalId) {
		this.formatApprovalId = formatApprovalId;
	}
	

	@Column(name="PERSON_IN_CHARGE")
	public String getPersonInCharge() {
		return personInCharge;
	}
	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}
	

	@Column(name="APPROVAL_SEQUENCE")
	public Integer getApprovalSequence() {
		return approvalSequence;
	}
	public void setApprovalSequence(Integer approvalSequence) {
		this.approvalSequence = approvalSequence;
	}
	

	@Column(name="STATUS_AKTIF")
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
