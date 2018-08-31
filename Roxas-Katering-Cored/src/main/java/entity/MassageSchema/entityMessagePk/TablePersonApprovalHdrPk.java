package entity.MassageSchema.entityMessagePk;

import java.io.Serializable;

public class TablePersonApprovalHdrPk implements Serializable{

	private static final long serialVersionUID = 1L;
	private String formatApprovalId;
	
	public String getFormatApprovalId() {
		return formatApprovalId;
	}

	public void setFormatApprovalId(String formatApprovalId) {
		this.formatApprovalId = formatApprovalId;
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
