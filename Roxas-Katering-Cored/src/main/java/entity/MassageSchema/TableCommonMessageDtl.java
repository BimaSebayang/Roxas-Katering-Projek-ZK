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

import entity.MassageSchema.entityMessagePk.TableCommonMessageDtlPk;

@Entity
@Table(name="MESSAGE.TABLE_COMMON_MESSAGE_DTL")
@IdClass(TableCommonMessageDtlPk.class)
public class TableCommonMessageDtl implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String messageIdDtl;
	private String messageId;
	private String messageTemplate;
	private String messageAttachment;
	private String messageStatus;
	private Date createdDate;
	private String createdBy;
	private String projekCode;
	
	
	@Id
	@Column(name="MESSAGE_ID_DTL")
	public String getMessageIdDtl() {
		return messageIdDtl;
	}
	public void setMessageIdDtl(String messageIdDtl) {
		this.messageIdDtl = messageIdDtl;
	}
	
	@Column(name="MESSAGE_ID")
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
	@Column(name="MESSAGE_TEMPLATE")
	public String getMessageTemplate() {
		return messageTemplate;
	}
	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = messageTemplate;
	}
	
	@Column(name="MESSAGE_ATTACHMENT")
	public String getMessageAttachment() {
		return messageAttachment;
	}
	public void setMessageAttachment(String messageAttachment) {
		this.messageAttachment = messageAttachment;
	}
	
	@Column(name="MESSAGE_STATUS")
	public String getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	
	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="PPROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
