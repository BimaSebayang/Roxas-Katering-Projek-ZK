package dto.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TableMasterMenuMasakanDto  implements Serializable {
	private static final long serialVersionUID = 1L;
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
	public String getKodeMakanan() {
		return kodeMakanan;
	}
	public void setKodeMakanan(String kodeMakanan) {
		this.kodeMakanan = kodeMakanan;
	}
	public String getNamaMakanan() {
		return namaMakanan;
	}
	public void setNamaMakanan(String namaMakanan) {
		this.namaMakanan = namaMakanan;
	}
	public String getKodeResep() {
		return kodeResep;
	}
	public void setKodeResep(String kodeResep) {
		this.kodeResep = kodeResep;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
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
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
	}
	public String getStatusApproval() {
		return statusApproval;
	}
	public void setStatusApproval(String statusApproval) {
		this.statusApproval = statusApproval;
	}
	public BigDecimal getHarga() {
		return harga;
	}
	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}
	public String getGambarMenu() {
		return gambarMenu;
	}
	public void setGambarMenu(String gambarMenu) {
		this.gambarMenu = gambarMenu;
	}
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
