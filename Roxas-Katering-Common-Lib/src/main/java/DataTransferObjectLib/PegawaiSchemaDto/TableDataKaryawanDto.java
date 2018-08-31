package DataTransferObjectLib.PegawaiSchemaDto;

import java.io.Serializable;
import java.util.Date;


public class TableDataKaryawanDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 private String id;
     private Character jenisKelamin;
     private String nik;
     private String noKk;
     private String noNpwp;
     private String berkasUpload;
     private String photo;
     private String namaKaryawan;
     private Date createdDate;
     private String createdBy;
     private Date updatedDate;
     private String updatedBy;
     private String createdByName;
     private String updatedByName;
     private String jobId;
     private String jobDesk;
     private String roleId;
     private String roleDescription;
     private String jenisKelaminDescription;
     private String statusName;
     private String projekCode;
     
     
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public String getUpdatedByName() {
		return updatedByName;
	}
	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}
	public String getJobDesk() {
		return jobDesk;
	}
	public void setJobDesk(String jobDesk) {
		this.jobDesk = jobDesk;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public String getJenisKelaminDescription() {
		return jenisKelaminDescription;
	}
	public void setJenisKelaminDescription(String jenisKelaminDescription) {
		this.jenisKelaminDescription = jenisKelaminDescription;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Character getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(Character jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getNoKk() {
		return noKk;
	}
	public void setNoKk(String noKk) {
		this.noKk = noKk;
	}
	public String getNoNpwp() {
		return noNpwp;
	}
	public void setNoNpwp(String noNpwp) {
		this.noNpwp = noNpwp;
	}

	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
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
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getBerkasUpload() {
		return berkasUpload;
	}
	public void setBerkasUpload(String berkasUpload) {
		this.berkasUpload = berkasUpload;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
