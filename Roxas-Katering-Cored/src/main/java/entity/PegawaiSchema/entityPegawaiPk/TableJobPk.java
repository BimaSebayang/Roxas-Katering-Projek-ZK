package entity.PegawaiSchema.entityPegawaiPk;

import java.io.Serializable;

import javax.persistence.Embeddable;


public class TableJobPk implements Serializable{

	private static final long serialVersionUID = 1L;
 
	private String jid;

	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
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
