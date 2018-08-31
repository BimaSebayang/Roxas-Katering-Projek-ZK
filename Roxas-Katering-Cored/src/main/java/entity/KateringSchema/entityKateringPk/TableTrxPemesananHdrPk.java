package entity.KateringSchema.entityKateringPk;

import java.io.Serializable;



public class TableTrxPemesananHdrPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String kodePemesanan;

	public String getKodePemesanan() {
		return kodePemesanan;
	}

	public void setKodePemesanan(String kodePemesanan) {
		this.kodePemesanan = kodePemesanan;
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
