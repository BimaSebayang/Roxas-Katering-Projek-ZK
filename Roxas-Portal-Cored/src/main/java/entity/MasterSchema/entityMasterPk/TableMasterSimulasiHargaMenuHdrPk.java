package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterSimulasiHargaMenuHdrPk implements Serializable{
	private static final long serialVersionUID = 1L;
	 private String kodeSimulasi;

	public String getKodeSimulasi() {
		return kodeSimulasi;
	}

	public void setKodeSimulasi(String kodeSimulasi) {
		this.kodeSimulasi = kodeSimulasi;
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
