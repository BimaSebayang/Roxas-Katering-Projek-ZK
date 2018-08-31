package entity.KateringSchema.entityKateringPk;

import java.io.Serializable;

public class TableTrxPajakHdrPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String kodePajak;

	public String getKodePajak() {
		return kodePajak;
	}

	public void setKodePajak(String kodePajak) {
		this.kodePajak = kodePajak;
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
