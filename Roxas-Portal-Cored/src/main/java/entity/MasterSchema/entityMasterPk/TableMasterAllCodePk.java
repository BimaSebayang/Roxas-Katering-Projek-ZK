package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterAllCodePk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 private String mstCode;

	public String getMstCode() {
		return mstCode;
	}

	public void setMstCode(String mstCode) {
		this.mstCode = mstCode;
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
