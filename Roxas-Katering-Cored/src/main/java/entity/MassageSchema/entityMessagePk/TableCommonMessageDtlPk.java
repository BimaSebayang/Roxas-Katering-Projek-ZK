package entity.MassageSchema.entityMessagePk;

import java.io.Serializable;

public class TableCommonMessageDtlPk implements Serializable{
	private static final long serialVersionUID = 1L;

	private String messageIdDtl;

	public String getMessageIdDtl() {
		return messageIdDtl;
	}

	public void setMessageIdDtl(String messageIdDtl) {
		this.messageIdDtl = messageIdDtl;
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
