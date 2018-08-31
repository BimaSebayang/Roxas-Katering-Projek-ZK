package entity.MenuSchema;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.MenuSchema.entityMenuPk.TableConfigurationMenuPk;

@Entity
@Table(name="MENU.TABLE_CONFIGURATION_MENU")
@IdClass(TableConfigurationMenuPk.class)
public class TableConfigurationMenu implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private String menuCode;
    private String menuButton;
    private String userId;
    private String status;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String projekCode;
    
    @Column(name = "PROJEK_CODE")
    public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
    
    
	@Column(name="MENU_CODE")
	public String getMenuCode() {
		return menuCode;
	}
	
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	

	@Column(name="MENU_BUTTON")
	public String getMenuButton() {
		return menuButton;
	}
	public void setMenuButton(String menuButton) {
		this.menuButton = menuButton;
	}
	

	@Column(name="USER_ID")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Id
	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP) 
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
	@Temporal(TemporalType.TIMESTAMP) 
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
    
    
    
}
