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

import entity.MasterSchema.entityMasterPk.TableMasterPelangganKateringPk;


@Entity
@Table(name = "MASTER.TABLE_MASTER_PELANGGAN_KATERING")
@IdClass(TableMasterPelangganKateringPk.class)
public class TableMasterPelangganKatering {
	private String kodePelanggan;
	private String namaPelanggan;
	private String tipePelanggan;
	private String kodeKupon;
	private String keterangan;
	private BigDecimal komposisiPesanan;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String alamatPelanggan;
	private String password;
	private String kodePosPelanggan;
	private Integer statusAktif;
	private String statusApproval;
	private String projekCode;
	private String kontakPelanggan;
	
	@Id
	@Column(name = "KODE_PELANGGAN")
	public String getKodePelanggan() {
		return kodePelanggan;
	}
	public void setKodePelanggan(String kodePelanggan) {
		this.kodePelanggan = kodePelanggan;
	}
	
	@Column(name = "NAMA_PELANGGAN")
	public String getNamaPelanggan() {
		return namaPelanggan;
	}
	public void setNamaPelanggan(String namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}
	
	@Column(name = "TIPE_PELANGGAN")
	public String getTipePelanggan() {
		return tipePelanggan;
	}
	public void setTipePelanggan(String tipePelanggan) {
		this.tipePelanggan = tipePelanggan;
	}
	
	@Column(name = "KODE_KUPON")
	public String getKodeKupon() {
		return kodeKupon;
	}
	public void setKodeKupon(String kodeKupon) {
		this.kodeKupon = kodeKupon;
	}
	
	@Column(name = "KETERANGAN")
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	@Column(name = "KOMPOSISI_PESANAN")
	public BigDecimal getKomposisiPesanan() {
		return komposisiPesanan;
	}
	public void setKomposisiPesanan(BigDecimal komposisiPesanan) {
		this.komposisiPesanan = komposisiPesanan;
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
	
	@Column(name = "ALAMAT_PELANGGAN")
	public String getAlamatPelanggan() {
		return alamatPelanggan;
	}
	public void setAlamatPelanggan(String alamatPelanggan) {
		this.alamatPelanggan = alamatPelanggan;
	}
	
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "KODE_POS_PELANGGAN")
	public String getKodePosPelanggan() {
		return kodePosPelanggan;
	}
	public void setKodePosPelanggan(String kodePosPelanggan) {
		this.kodePosPelanggan = kodePosPelanggan;
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
	
	@Column(name = "KONTAK_PELANGGAN")
	public String getKontakPelanggan() {
		return kontakPelanggan;
	}
	public void setKontakPelanggan(String kontakPelanggan) {
		this.kontakPelanggan = kontakPelanggan;
	}
	
	

}
