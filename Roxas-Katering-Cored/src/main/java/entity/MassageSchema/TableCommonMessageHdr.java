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

import entity.MassageSchema.entityMessagePk.TableCommonMessageHdrPk;

@Entity
@Table(name="MESSAGE.TABLE_COMMON_MESSAGE_HDR")
@IdClass(TableCommonMessageHdrPk.class)
public class TableCommonMessageHdr implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String messageId;
	private String messageSubject;
	private String messageReceiver;
	private String messageCcReceiver;
	private String messageStatus;
	private Date createdDate;
	private String createdBy;
	private String projekCode;
	

	@Id
	@Column(name="MESSAGE_ID")
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
	@Column(name="MESSAGE_SUBJECT")
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	
	@Column(name="MESSAGE_RECEIVER")
	public String getMessageReceiver() {
		return messageReceiver;
	}
	public void setMessageReceiver(String messageReceiver) {
		this.messageReceiver = messageReceiver;
	}
	
	@Column(name="MESSAGE_CC_RECEIVER")
	public String getMessageCcReceiver() {
		return messageCcReceiver;
	}
	public void setMessageCcReceiver(String messageCcReceiver) {
		this.messageCcReceiver = messageCcReceiver;
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
