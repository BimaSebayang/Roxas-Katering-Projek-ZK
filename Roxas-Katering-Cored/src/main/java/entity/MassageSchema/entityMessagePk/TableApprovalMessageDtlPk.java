package entity.MassageSchema.entityMessagePk;

import java.io.Serializable;

public class TableApprovalMessageDtlPk  implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private String messageDtlId;


	public String getMessageDtlId() {
		return messageDtlId;
	}


	public void setMessageDtlId(String messageDtlId) {
		this.messageDtlId = messageDtlId;
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
