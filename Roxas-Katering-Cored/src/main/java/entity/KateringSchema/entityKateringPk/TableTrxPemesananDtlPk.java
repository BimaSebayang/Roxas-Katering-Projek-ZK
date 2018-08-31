package entity.KateringSchema.entityKateringPk;

import java.io.Serializable;

public class TableTrxPemesananDtlPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String kodePemesananDtl;

	public String getKodePemesananDtl() {
		return kodePemesananDtl;
	}

	public void setKodePemesananDtl(String kodePemesananDtl) {
		this.kodePemesananDtl = kodePemesananDtl;
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
