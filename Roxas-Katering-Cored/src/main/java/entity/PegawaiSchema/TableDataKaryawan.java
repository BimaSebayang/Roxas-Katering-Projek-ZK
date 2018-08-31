package entity.PegawaiSchema;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mysql.jdbc.Blob;

import entity.PegawaiSchema.entityPegawaiPk.TableDataKaryawanPk;

@Entity
@Table(name="PEGAWAI.TABLE_DATA_KARYAWAN")
@IdClass(TableDataKaryawanPk.class)
public class TableDataKaryawan {
      private String pegawaiId;
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
      private String projekCode;
      
    @Column(name = "PROJEK_CODE")
    public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	@Id
      @Column(name = "PEGAWAI_ID")
	public String getPegawaiId() {
		return pegawaiId;
	}
	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
	}
	@Column(name = "JENIS_KELAMIN")
	public Character getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(Character jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	
	@Column(name = "NIK")
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	
	@Column(name = "NO_KK")
	public String getNoKk() {
		return noKk;
	}
	public void setNoKk(String noKk) {
		this.noKk = noKk;
	}
	
	@Column(name = "NO_NPWP")
	public String getNoNpwp() {
		return noNpwp;
	}
	public void setNoNpwp(String noNpwp) {
		this.noNpwp = noNpwp;
	}
	
	@Column(name = "BERKAS_UPLOAD")	
	public String getBerkasUpload() {
		return berkasUpload;
	}
	public void setBerkasUpload(String berkasUpload) {
		this.berkasUpload = berkasUpload;
	}
	
	@Column(name = "PHOTO")
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Column(name = "NAMA_KARYAWAN")
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.DATE) 
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.DATE) 
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
      
      
}
