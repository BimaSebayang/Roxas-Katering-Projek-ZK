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

import entity.MasterSchema.entityMasterPk.TableMasterProsesPemesananPk;


@Entity
@Table(name = "MASTER.TABLE_MASTER_PROSES_PEMESANAN")
@IdClass(TableMasterProsesPemesananPk.class)
public class TableMasterProsesPemesanan {
	private String kodeProses;
	private String namaProses;
	private BigDecimal hargaTambahananProses;
	private String tipePengirimanProses;
	private String kodePengiriman;
	private BigDecimal hargaPengiriman;
	private BigDecimal hargaAdminDelivery;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private Integer statusAktif;
	private String statusApproval;
	private String projekCode;
	
	@Id
	@Column(name = "KODE_PROSES")
	public String getKodeProses() {
		return kodeProses;
	}
	public void setKodeProses(String kodeProses) {
		this.kodeProses = kodeProses;
	}
	
	@Column(name = "NAMA_PROSES")
	public String getNamaProses() {
		return namaProses;
	}
	public void setNamaProses(String namaProses) {
		this.namaProses = namaProses;
	}
	
	@Column(name = "HARGA_TAMBAHAN_PROSES")
	public BigDecimal getHargaTambahananProses() {
		return hargaTambahananProses;
	}
	public void setHargaTambahananProses(BigDecimal hargaTambahananProses) {
		this.hargaTambahananProses = hargaTambahananProses;
	}
	
	@Column(name = "TIPE_PENGIRIMAN_PROSES")
	public String getTipePengirimanProses() {
		return tipePengirimanProses;
	}
	public void setTipePengirimanProses(String tipePengirimanProses) {
		this.tipePengirimanProses = tipePengirimanProses;
	}
	
	@Column(name = "KODE_PENGIRIMAN")
	public String getKodePengiriman() {
		return kodePengiriman;
	}
	public void setKodePengiriman(String kodePengiriman) {
		this.kodePengiriman = kodePengiriman;
	}
	
	@Column(name = "HARGA_PENGIRIMAN")
	public BigDecimal getHargaPengiriman() {
		return hargaPengiriman;
	}
	public void setHargaPengiriman(BigDecimal hargaPengiriman) {
		this.hargaPengiriman = hargaPengiriman;
	}
	
	@Column(name = "HARGA_ADMIN_DELIVERY")
	public BigDecimal getHargaAdminDelivery() {
		return hargaAdminDelivery;
	}
	public void setHargaAdminDelivery(BigDecimal hargaAdminDelivery) {
		this.hargaAdminDelivery = hargaAdminDelivery;
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
