package entity.PegawaiSchema.entityPegawaiPk;

import java.io.Serializable;

import javax.persistence.Embeddable;

public class TablePengenalPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String pegawaiId;
	
	public String getPegawaiId() {
		return pegawaiId;
	}

	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
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
