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

import entity.MassageSchema.entityMessagePk.TableApprovalMessageDtlPk;

@Entity
@Table(name="MESSAGE.TABLE_APPROVAL_MESSAGE_DTL")
@IdClass(TableApprovalMessageDtlPk.class)
public class TableApprovalMessageDtl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String messageDtlId;
	private String messageId;
	private String approvalPerson;
	private Date approvalDate;
	private Integer approvalSequence;
    private String resultStatusApproval;
    private String createdBy;
    private Date createdDate;
    private String notes;
    private String projekCode;
    
    @Id
    @Column(name="MESSAGE_DTL_ID")
	public String getMessageDtlId() {
		return messageDtlId;
	}
	public void setMessageDtlId(String messageDtlId) {
		this.messageDtlId = messageDtlId;
	}
	
	@Column(name="MESSAGE_ID")
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
	
	@Column(name="APPROVAL_PERSON")
	public String getApprovalPerson() {
		return approvalPerson;
	}
	public void setApprovalPerson(String approvalPerson) {
		this.approvalPerson = approvalPerson;
	}
	

	@Column(name="APPROVAL_DATE")
	@Temporal(TemporalType.TIMESTAMP) 
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	
	@Column(name="APPROVAL_SEQUENCE")
	public Integer getApprovalSequence() {
		return approvalSequence;
	}
	public void setApprovalSequence(Integer approvalSequence) {
		this.approvalSequence = approvalSequence;
	}
	
	@Column(name="RESULT_STATUS_APPROVAL")
	public String getResultStatusApproval() {
		return resultStatusApproval;
	}
	public void setResultStatusApproval(String resultStatusApproval) {
		this.resultStatusApproval = resultStatusApproval;
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
	
	@Column(name="NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Column(name="PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
    
    
}
