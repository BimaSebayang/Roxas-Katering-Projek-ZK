package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterKotaPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String kodeKota;

	public String getKodeKota() {
		return kodeKota;
	}

	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
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
