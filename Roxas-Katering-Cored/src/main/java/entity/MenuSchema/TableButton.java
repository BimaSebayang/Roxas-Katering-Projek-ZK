package entity.MenuSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.MenuSchema.entityMenuPk.TableButtonPk;

@Entity
@Table(name="MENU.TABLE_BUTTON")
@IdClass(TableButtonPk.class)
public class TableButton {
   private String buttonCode;
   private String buttonName;
   private String notes;
   private int status;
   private String buttonAction;
   private String buttonIcon;
   private String projekCode;
   
   @Column(name = "PROJEK_CODE")
   public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}


   @Column(name = "BUTTON_ICON")
   public String getButtonIcon() {
	return buttonIcon;
}
public void setButtonIcon(String buttonIcon) {
	this.buttonIcon = buttonIcon;
}
@Column(name = "BUTTON_ACTION")
   public String getButtonAction() {
	return buttonAction;
}
public void setButtonAction(String buttonAction) {
	this.buttonAction = buttonAction;
}
@Id
	@Column(name="BUTTON_CODE")   
public String getButtonCode() {
	return buttonCode;
}
public void setButtonCode(String buttonCode) {
	this.buttonCode = buttonCode;
}


	@Column(name="BUTTON_NAME")  
public String getButtonName() {
	return buttonName;
}
public void setButtonName(String buttonName) {
	this.buttonName = buttonName;
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
   
   
}
