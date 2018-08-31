package dto.MenuSchemaDto;

import java.io.Serializable;

public class TableButtonDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String buttonCode;
	   private String buttonName;
	   private String notes;
	   private int status;
	   private String statusName;
	private String buttonAction;
	private String buttonIcon;
	   
	  public String getButtonIcon() {
		return buttonIcon;
	}
	public void setButtonIcon(String buttonIcon) {
		this.buttonIcon = buttonIcon;
	}
	public String getStatusName() {
			return statusName;
		}
		public void setStatusName(String statusName) {
			this.statusName = statusName;
		}
	
	public String getButtonAction() {
		return buttonAction;
	}
	public void setButtonAction(String buttonAction) {
		this.buttonAction = buttonAction;
	}
	public String getButtonCode() {
		return buttonCode;
	}
	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}
	public String getButtonName() {
		return buttonName;
	}
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
