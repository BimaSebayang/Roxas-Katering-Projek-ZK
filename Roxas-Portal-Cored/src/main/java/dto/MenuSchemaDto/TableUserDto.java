package dto.MenuSchemaDto;

import java.io.Serializable;
import java.util.Date;

public class TableUserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userId;
    private String pegawaiId;
    private String password;
    private int status;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String projekCode;
    
    private String createdByName;
    private String pegawaiName;
    private String statusUser;
    
	public String getStatusUser() {
		return statusUser;
	}
	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public String getPegawaiName() {
		return pegawaiName;
	}
	public void setPegawaiName(String pegawaiName) {
		this.pegawaiName = pegawaiName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPegawaiId() {
		return pegawaiId;
	}
	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
    
    
	
}
