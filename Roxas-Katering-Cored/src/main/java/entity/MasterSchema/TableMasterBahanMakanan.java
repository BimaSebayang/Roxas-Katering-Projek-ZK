package entity.MasterSchema;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import entity.MasterSchema.entityMasterPk.TableMasterBahanMakananPk;

@Entity
@Table(name = "MASTER.TABLE_MASTER_BAHAN_MAKANAN")
@IdClass(TableMasterBahanMakananPk.class)
public class TableMasterBahanMakanan {

	private String kodeBahan;
	private String namaBahan;
	private String kodeResep;
	private BigDecimal hargaBahan;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private Integer statusAktif;
	private String statusApproval;
	private String projekCode;

	@Id
	@Column(name = "KODE_BAHAN")
	public String getKodeBahan() {
		return kodeBahan;
	}

	public void setKodeBahan(String kodeBahan) {
		this.kodeBahan = kodeBahan;
	}

	@Column(name = "NAMA_BAHAN")
	public String getNamaBahan() {
		return namaBahan;
	}

	public void setNamaBahan(String namaBahan) {
		this.namaBahan = namaBahan;
	}

	  @Column(name = "KODE_RESEP")
	public String getKodeResep() {
		return kodeResep;
	}

	public void setKodeResep(String kodeResep) {
		this.kodeResep = kodeResep;
	}

	  @Column(name = "HARGA_BAHAN")
	public BigDecimal getHargaBahan() {
		return hargaBahan;
	}

	public void setHargaBahan(BigDecimal hargaBahan) {
		this.hargaBahan = hargaBahan;
	}

	  @Column(name = "CREATED_DATE")
	  @Temporal(TemporalType.TIMESTAMP) 
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
	 @Temporal(TemporalType.TIMESTAMP) 
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

	 @Column(name = "STATUS_AKTIF")
	public Integer getStatusAktif() {
		return statusAktif;
	}

	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
	}

	 @Column(name = "STATUS_APPROVAL")
	public String getStatusApproval() {
		return statusApproval;
	}

	public void setStatusApproval(String statusApproval) {
		this.statusApproval = statusApproval;
	}

	 @Column(name = "PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}

	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
