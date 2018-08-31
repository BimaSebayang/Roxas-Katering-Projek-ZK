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

import entity.MassageSchema.entityMessagePk.TableApprovalMessageHdrPk;

@Entity
@Table(name="MESSAGE.TABLE_APPROVAL_MESSAGE_HDR")
@IdClass(TableApprovalMessageHdrPk.class)
public class TableApprovalMessageHdr  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private String messageId;
	private String trxId;
	private String formatId;
	private String menuCode;
	private String createdBy;
	private Date createdDate;
	private String formatApprovalId;
	private String lastApproval;
	private Date lastApprovalDate;
	private String finalStatusApproval;
	private String projekCode;
	
	@Id
	@Column(name="MESSAGE_ID")
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
	@Column(name="TRX_ID")
	public String getTrxId() {
		return trxId;
	}
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}
	
	@Column(name="FORMAT_ID")
	public String getFormatId() {
		return formatId;
	}
	public void setFormatId(String formatId) {
		this.formatId = formatId;
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
	
	@Column(name="FORMAT_APPROVAL_ID")
	public String getFormatApprovalId() {
		return formatApprovalId;
	}
	public void setFormatApprovalId(String formatApprovalId) {
		this.formatApprovalId = formatApprovalId;
	}
	
	@Column(name="LAST_APPROVAL")
	public String getLastApproval() {
		return lastApproval;
	}
	public void setLastApproval(String lastApproval) {
		this.lastApproval = lastApproval;
	}
	
	@Column(name="LAST_APPROVAL_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastApprovalDate() {
		return lastApprovalDate;
	}
	public void setLastApprovalDate(Date lastApprovalDate) {
		this.lastApprovalDate = lastApprovalDate;
	}
	
	@Column(name="FINAL_STATUS_APPROVAL")
	public String getFinalStatusApproval() {
		return finalStatusApproval;
	}
	public void setFinalStatusApproval(String finalStatusApproval) {
		this.finalStatusApproval = finalStatusApproval;
	}
	
	@Column(name="PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	
	
}
