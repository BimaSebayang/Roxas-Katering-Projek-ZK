package dto.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TableMasterPelangganKateringDto  implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	public String getKodePelanggan() {
		return kodePelanggan;
	}
	public void setKodePelanggan(String kodePelanggan) {
		this.kodePelanggan = kodePelanggan;
	}
	public String getNamaPelanggan() {
		return namaPelanggan;
	}
	public void setNamaPelanggan(String namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}
	public String getTipePelanggan() {
		return tipePelanggan;
	}
	public void setTipePelanggan(String tipePelanggan) {
		this.tipePelanggan = tipePelanggan;
	}
	public String getKodeKupon() {
		return kodeKupon;
	}
	public void setKodeKupon(String kodeKupon) {
		this.kodeKupon = kodeKupon;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public BigDecimal getKomposisiPesanan() {
		return komposisiPesanan;
	}
	public void setKomposisiPesanan(BigDecimal komposisiPesanan) {
		this.komposisiPesanan = komposisiPesanan;
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
	public String getAlamatPelanggan() {
		return alamatPelanggan;
	}
	public void setAlamatPelanggan(String alamatPelanggan) {
		this.alamatPelanggan = alamatPelanggan;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKodePosPelanggan() {
		return kodePosPelanggan;
	}
	public void setKodePosPelanggan(String kodePosPelanggan) {
		this.kodePosPelanggan = kodePosPelanggan;
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
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}

}
