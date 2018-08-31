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

import entity.MasterSchema.entityMasterPk.TableMasterMenuMasakanPk;

@Entity
@Table(name="MASTER.TABLE_MASTER_MENU_MASAKAN")
@IdClass(TableMasterMenuMasakanPk.class)
public class TableMasterMenuMasakan {

	private String kodeMakanan;
	private String namaMakanan;
	private String kodeResep;
	private String keterangan;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private Integer statusAktif;
	private String statusApproval;
	private BigDecimal harga;
	private String gambarMenu;
	private String projekCode;
	
	
	@Id
	@Column(name = "KODE_MAKANAN")
	public String getKodeMakanan() {
		return kodeMakanan;
	}
	public void setKodeMakanan(String kodeMakanan) {
		this.kodeMakanan = kodeMakanan;
	}
	
	@Column(name = "NAMA_MAKANAN")
	public String getNamaMakanan() {
		return namaMakanan;
	}
	public void setNamaMakanan(String namaMakanan) {
		this.namaMakanan = namaMakanan;
	}
	
	@Column(name = "KODE_RESEP")
	public String getKodeResep() {
		return kodeResep;
	}
	public void setKodeResep(String kodeResep) {
		this.kodeResep = kodeResep;
	}
	
	@Column(name = "KETERANGAN")
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
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
	
	@Column(name = "HARGA")
	public BigDecimal getHarga() {
		return harga;
	}
	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}
	
	@Column(name = "GAMBAR_MENU")
	public String getGambarMenu() {
		return gambarMenu;
	}
	public void setGambarMenu(String gambarMenu) {
		this.gambarMenu = gambarMenu;
	}
	
	@Column(name = "PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
