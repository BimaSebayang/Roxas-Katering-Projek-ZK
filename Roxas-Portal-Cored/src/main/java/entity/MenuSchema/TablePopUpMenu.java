package entity.MenuSchema;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.MenuSchema.entityMenuPk.TableMenuPk;
import entity.MenuSchema.entityMenuPk.TablePopUpMenuPk;


@Entity
@Table(name="MENU.TABLE_POPUP_MENU")
@IdClass(TablePopUpMenuPk.class)
public class TablePopUpMenu {

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
     
	    @Column(name = "PROJEK_CODE")
	    public String getProjekCode() {
			return projekCode;
		}
		public void setProjekCode(String projekCode) {
			this.projekCode = projekCode;
		}
	
	@Id
	@Column(name="POPUP_MENU_ID")
	public String getPopupMenuId() {
		return popupMenuId;
	}
	public void setPopupMenuId(String popupMenuId) {
		this.popupMenuId = popupMenuId;
	}
	
	@Column(name="POPUP_MENU_NAME")
	public String getPopupMenuName() {
		return popupMenuName;
	}
	public void setPopupMenuName(String popupMenuName) {
		this.popupMenuName = popupMenuName;
	}
	
	@Column(name="POPUP_MENU_URL")
	public String getPopupMenuUrl() {
		return popupMenuUrl;
	}
	public void setPopupMenuUrl(String popupMenuUrl) {
		this.popupMenuUrl = popupMenuUrl;
	}
	
	@Column(name="POPUP_MENU_FILE")
	public String getPopupMenuFile() {
		return popupMenuFile;
	}
	public void setPopupMenuFile(String popupMenuFile) {
		this.popupMenuFile = popupMenuFile;
	}
	
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name="LIST_ACCESSED_USER")
	public byte[] getListAccessedUser() {
		return listAccessedUser;
	}
	public void setListAccessedUser(byte[] listAccessedUser) {
		this.listAccessedUser = listAccessedUser;
	}
	
	@Column(name="STATUS")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
