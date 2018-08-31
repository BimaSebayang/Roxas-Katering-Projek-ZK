package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterSimulasiHargaMenuDtlPk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String kodeSimulasiTrx;

	public String getKodeSimulasiTrx() {
		return kodeSimulasiTrx;
	}

	public void setKodeSimulasiTrx(String kodeSimulasiTrx) {
		this.kodeSimulasiTrx = kodeSimulasiTrx;
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
