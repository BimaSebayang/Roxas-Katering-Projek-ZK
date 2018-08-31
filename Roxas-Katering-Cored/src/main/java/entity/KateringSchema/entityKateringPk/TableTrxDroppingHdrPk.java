package entity.KateringSchema.entityKateringPk;

import java.io.Serializable;

public class TableTrxDroppingHdrPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String kodeDropping;


	public String getKodeDropping() {
		return kodeDropping;
	}


	public void setKodeDropping(String kodeDropping) {
		this.kodeDropping = kodeDropping;
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
