package entity.PegawaiSchema.entityPegawaiPk;

import java.io.Serializable;

import javax.persistence.Embeddable;


public class TableRolePk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String roleId;
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
