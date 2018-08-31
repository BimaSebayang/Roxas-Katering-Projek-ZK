package entity.MasterSchema.entityMasterPk;

import java.io.Serializable;

public class TableMasterBahanMakananPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String kodeBahan;

	public String getKodeBahan() {
		return kodeBahan;
	}

	public void setKodeBahan(String kodeBahan) {
		this.kodeBahan = kodeBahan;
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
