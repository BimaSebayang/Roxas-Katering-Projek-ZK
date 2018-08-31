package entity.PegawaiSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.PegawaiSchema.entityPegawaiPk.TablePengenalPk;
import entity.PegawaiSchema.entityPegawaiPk.TableRolePk;


@Entity
@Table(name="PEGAWAI.TABLE_ROLE")
@IdClass(TableRolePk.class)
public class TableRole {
       private String roleId;
       private String roleDesription;
       private String roleUnderneath;
       private String notes;
       private String projekCode;
       
       @Column(name = "PROJEK_CODE")
       public String getProjekCode() {
   		return projekCode;
   	}
   	public void setProjekCode(String projekCode) {
   		this.projekCode = projekCode;
   	}
       @Id
       @Column(name="ROLE_ID")    
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
    @Column(name="ROLE_DESCRIPTION")
	public String getRoleDesription() {
		return roleDesription;
	}
	public void setRoleDesription(String roleDesription) {
		this.roleDesription = roleDesription;
	}
	
	
	 @Column(name="ROLE_UNDERNEATH")
	public String getRoleUnderneath() {
		return roleUnderneath;
	}
	public void setRoleUnderneath(String roleUnderneath) {
		this.roleUnderneath = roleUnderneath;
	}
	
	@Column(name="NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
       
 
       
}
