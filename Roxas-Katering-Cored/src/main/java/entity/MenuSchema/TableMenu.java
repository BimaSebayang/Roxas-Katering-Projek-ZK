package entity.MenuSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.MenuSchema.entityMenuPk.TableMenuPk;

@Entity
@Table(name="MENU.TABLE_MENU")
@IdClass(TableMenuPk.class)
public class TableMenu {
      private String menuCode;
      private String menuName;
      private String notes;
      private int status;
      private String menuUrl;
      private String projekCode;
      
      @Column(name = "PROJEK_CODE")
      public String getProjekCode() {
  		return projekCode;
  	}
  	public void setProjekCode(String projekCode) {
  		this.projekCode = projekCode;
  	}
      
    @Id
  	@Column(name="MENU_CODE")     
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	
	@Column(name="MENU_NAME")     
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	@Column(name="NOTES")     
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Column(name="STATUS")     
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name="MENU_URL")
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
}
