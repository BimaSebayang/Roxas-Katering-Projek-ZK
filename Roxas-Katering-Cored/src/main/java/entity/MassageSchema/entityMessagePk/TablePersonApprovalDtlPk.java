package entity.MassageSchema.entityMessagePk;

import java.io.Serializable;

public class TablePersonApprovalDtlPk implements Serializable{

	private static final long serialVersionUID = 1L;
	private String trxIdDtl;

	public String getTrxIdDtl() {
		return trxIdDtl;
	}

	public void setTrxIdDtl(String trxIdDtl) {
		this.trxIdDtl = trxIdDtl;
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
