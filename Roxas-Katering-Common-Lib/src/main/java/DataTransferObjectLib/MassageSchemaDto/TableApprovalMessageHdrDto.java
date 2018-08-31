package DataTransferObjectLib.MassageSchemaDto;

import java.io.Serializable;
import java.util.Date;

public class TableApprovalMessageHdrDto implements Serializable{

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
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getTrxId() {
		return trxId;
	}
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}
	public String getFormatId() {
		return formatId;
	}
	public void setFormatId(String formatId) {
		this.formatId = formatId;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getFormatApprovalId() {
		return formatApprovalId;
	}
	public void setFormatApprovalId(String formatApprovalId) {
		this.formatApprovalId = formatApprovalId;
	}
	public String getLastApproval() {
		return lastApproval;
	}
	public void setLastApproval(String lastApproval) {
		this.lastApproval = lastApproval;
	}
	public Date getLastApprovalDate() {
		return lastApprovalDate;
	}
	public void setLastApprovalDate(Date lastApprovalDate) {
		this.lastApprovalDate = lastApprovalDate;
	}
	public String getFinalStatusApproval() {
		return finalStatusApproval;
	}
	public void setFinalStatusApproval(String finalStatusApproval) {
		this.finalStatusApproval = finalStatusApproval;
	}
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
