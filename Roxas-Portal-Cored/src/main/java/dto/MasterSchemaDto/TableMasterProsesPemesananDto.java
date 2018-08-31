package dto.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TableMasterProsesPemesananDto  implements Serializable {
	private static final long serialVersionUID = 1L;
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
	public String getKodeProses() {
		return kodeProses;
	}
	public void setKodeProses(String kodeProses) {
		this.kodeProses = kodeProses;
	}
	public String getNamaProses() {
		return namaProses;
	}
	public void setNamaProses(String namaProses) {
		this.namaProses = namaProses;
	}
	public BigDecimal getHargaTambahananProses() {
		return hargaTambahananProses;
	}
	public void setHargaTambahananProses(BigDecimal hargaTambahananProses) {
		this.hargaTambahananProses = hargaTambahananProses;
	}
	public String getTipePengirimanProses() {
		return tipePengirimanProses;
	}
	public void setTipePengirimanProses(String tipePengirimanProses) {
		this.tipePengirimanProses = tipePengirimanProses;
	}
	public String getKodePengiriman() {
		return kodePengiriman;
	}
	public void setKodePengiriman(String kodePengiriman) {
		this.kodePengiriman = kodePengiriman;
	}
	public BigDecimal getHargaPengiriman() {
		return hargaPengiriman;
	}
	public void setHargaPengiriman(BigDecimal hargaPengiriman) {
		this.hargaPengiriman = hargaPengiriman;
	}
	public BigDecimal getHargaAdminDelivery() {
		return hargaAdminDelivery;
	}
	public void setHargaAdminDelivery(BigDecimal hargaAdminDelivery) {
		this.hargaAdminDelivery = hargaAdminDelivery;
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
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}

}
