package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterPelangganKateringPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String kodePelanggan;

	public String getKodePelanggan() {
		return kodePelanggan;
	}

	public void setKodePelanggan(String kodePelanggan) {
		this.kodePelanggan = kodePelanggan;
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
