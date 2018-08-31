package entity.MenuSchema;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.MenuSchema.entityMenuPk.TableUserPk;
import entity.PegawaiSchema.TableDataKaryawan;

@Entity
@Table(name="MENU.TABLE_USER_PEGANTI")
@IdClass(TableUserPk.class)
public class TableUser{
	private String userId;
    private String pegawaiId;
    private String password;
    private int status;
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
    
	@Id
    @Column(name="USER_ID") 
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="PEGAWAI_ID")
	public String getPegawaiId() {
		return pegawaiId;
	}
	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="STATUS")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.DATE) 
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
	@Temporal(TemporalType.DATE) 
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
