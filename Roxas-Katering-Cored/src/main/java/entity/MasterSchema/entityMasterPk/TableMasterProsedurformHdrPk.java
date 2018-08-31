package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterProsedurformHdrPk implements Serializable{
	private static final long serialVersionUID = 1L;

	private String prosedurId;

	public String getProsedurId() {
		return prosedurId;
	}

	public void setProsedurId(String prosedurId) {
		this.prosedurId = prosedurId;
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
