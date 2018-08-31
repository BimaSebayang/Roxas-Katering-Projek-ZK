package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterProvinsiPk implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private String kodeProvinsi;


	public String getKodeProvinsi() {
		return kodeProvinsi;
	}


	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
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
