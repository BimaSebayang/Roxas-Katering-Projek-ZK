package DataTransferObjectLib.MenuSchemaDto;

import java.io.Serializable;
import java.util.Date;

public class TablePopUpMenuDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String popupMenuId;
	private String popupMenuName;
	private String popupMenuUrl;
	private String popupMenuFile;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private byte[] listAccessedUser;
	private int status;
	 private String projekCode;
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	public String getPopupMenuId() {
		return popupMenuId;
	}
	public void setPopupMenuId(String popupMenuId) {
		this.popupMenuId = popupMenuId;
	}
	public String getPopupMenuName() {
		return popupMenuName;
	}
	public void setPopupMenuName(String popupMenuName) {
		this.popupMenuName = popupMenuName;
	}
	public String getPopupMenuUrl() {
		return popupMenuUrl;
	}
	public void setPopupMenuUrl(String popupMenuUrl) {
		this.popupMenuUrl = popupMenuUrl;
	}
	public String getPopupMenuFile() {
		return popupMenuFile;
	}
	public void setPopupMenuFile(String popupMenuFile) {
		this.popupMenuFile = popupMenuFile;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public byte[] getListAccessedUser() {
		return listAccessedUser;
	}
	public void setListAccessedUser(byte[] listAccessedUser) {
		this.listAccessedUser = listAccessedUser;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
