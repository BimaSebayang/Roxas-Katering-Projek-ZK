package dto.PegawaiSchemaDto;

import java.io.Serializable;

public class TableRoleDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	  private String roleId;
      private String roleDesription;
      private String roleUnderneath;
      private String notes;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleDesription() {
		return roleDesription;
	}
	public void setRoleDesription(String roleDesription) {
		this.roleDesription = roleDesription;
	}
	public String getRoleUnderneath() {
		return roleUnderneath;
	}
	public void setRoleUnderneath(String roleUnderneath) {
		this.roleUnderneath = roleUnderneath;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
     
}
