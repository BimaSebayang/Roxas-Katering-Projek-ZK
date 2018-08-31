package entity.KateringSchema.entityKateringPk;

import java.io.Serializable;

public class TableTrxPajakDtlPk implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String kodePajakDtl;

	public String getKodePajakDtl() {
		return kodePajakDtl;
	}

	public void setKodePajakDtl(String kodePajakDtl) {
		this.kodePajakDtl = kodePajakDtl;
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
