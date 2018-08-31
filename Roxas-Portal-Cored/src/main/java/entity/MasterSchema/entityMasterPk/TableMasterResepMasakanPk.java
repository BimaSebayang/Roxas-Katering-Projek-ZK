package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterResepMasakanPk  implements Serializable{
	private static final long serialVersionUID = 1L;
	 private String kodeResep;

	public String getKodeResep() {
		return kodeResep;
	}

	public void setKodeResep(String kodeResep) {
		this.kodeResep = kodeResep;
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
