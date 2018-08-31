package entity.PortalSchema.PortalSchemaPk;

import java.io.Serializable;

public class TablePortalProjekPk implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String kodePortal;

	public String getKodePortal() {
		return kodePortal;
	}

	public void setKodePortal(String kodePortal) {
		this.kodePortal = kodePortal;
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
