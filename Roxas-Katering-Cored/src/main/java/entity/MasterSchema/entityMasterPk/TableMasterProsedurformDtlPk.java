package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterProsedurformDtlPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String prosedurIdDetail;
	
	public String getProsedurIdDetail() {
		return prosedurIdDetail;
	}

	public void setProsedurIdDetail(String prosedurIdDetail) {
		this.prosedurIdDetail = prosedurIdDetail;
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
