package entity.MassageSchema.entityMessagePk;

import java.io.Serializable;

public class TableApprovalMessageHdrPk implements Serializable{
	private static final long serialVersionUID = 1L;

	private String messageId;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
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
