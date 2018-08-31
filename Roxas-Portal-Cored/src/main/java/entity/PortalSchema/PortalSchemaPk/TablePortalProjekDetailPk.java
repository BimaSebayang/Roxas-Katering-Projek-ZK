package entity.PortalSchema.PortalSchemaPk;

import java.io.Serializable;

public class TablePortalProjekDetailPk  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	private String kodePortalDetail;
	
	
	public String getKodePortalDetail() {
		return kodePortalDetail;
	}

	public void setKodePortalDetail(String kodePortalDetail) {
		this.kodePortalDetail = kodePortalDetail;
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
