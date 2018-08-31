package entity.KateringSchema;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.KateringSchema.entityKateringPk.TableTrxPemesananHdrPk;

@Entity
@Table(name = "KATERING.TABLE_TRX_PEMESANAN_HDR")
@IdClass(TableTrxPemesananHdrPk.class)
public class TableTrxPemesananHdr {

	private String kodePemesanan;
	private String kodePelanggan;
	private Integer totalPesanan;
	private BigDecimal hargaTotalPesanan;
	private BigDecimal hargaTambahan;
	private BigDecimal hargaAkhir;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String statusPemesanan;
	private String statusApproval;
	private String tipePemesanan;
	private String projekCode;
	
	
	 @Id
	    @Column(name="KODE_PEMESANAN") 
	public String getKodePemesanan() {
		return kodePemesanan;
	}
	public void setKodePemesanan(String kodePemesanan) {
		this.kodePemesanan = kodePemesanan;
	}
	
	
	    @Column(name="KODE_PELANGGAN") 
	public String getKodePelanggan() {
		return kodePelanggan;
	}
	public void setKodePelanggan(String kodePelanggan) {
		this.kodePelanggan = kodePelanggan;
	}
	
	    @Column(name="TOTAL_PESANAN") 
	public Integer getTotalPesanan() {
		return totalPesanan;
	}
	public void setTotalPesanan(Integer totalPesanan) {
		this.totalPesanan = totalPesanan;
	}
	
	 @Column(name="HARGA_TOTAL_PESANAN") 
	public BigDecimal getHargaTotalPesanan() {
		return hargaTotalPesanan;
	}
	public void setHargaTotalPesanan(BigDecimal hargaTotalPesanan) {
		this.hargaTotalPesanan = hargaTotalPesanan;
	}
	
	 @Column(name="HARGA_TAMBAHAN") 
	public BigDecimal getHargaTambahan() {
		return hargaTambahan;
	}
	public void setHargaTambahan(BigDecimal hargaTambahan) {
		this.hargaTambahan = hargaTambahan;
	}
	
	 @Column(name="HARGA_AKHIR") 
	public BigDecimal getHargaAkhir() {
		return hargaAkhir;
	}
	public void setHargaAkhir(BigDecimal hargaAkhir) {
		this.hargaAkhir = hargaAkhir;
	}
	
	 @Column(name="CREATED_DATE")
	 @Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	 @Column(name="CREATED_BY") 
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	 @Column(name="UPDATED_DATE")
	 @Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	 @Column(name="UPDATED_BY") 
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	 @Column(name="STATUS_PEMESANAN") 
	public String getStatusPemesanan() {
		return statusPemesanan;
	}
	public void setStatusPemesanan(String statusPemesanan) {
		this.statusPemesanan = statusPemesanan;
	}
	
	 @Column(name="STATUS_APPROVAL") 
	public String getStatusApproval() {
		return statusApproval;
	}
	public void setStatusApproval(String statusApproval) {
		this.statusApproval = statusApproval;
	}
	
	 @Column(name="TIPE_PEMESANAN") 
	public String getTipePemesanan() {
		return tipePemesanan;
	}
	public void setTipePemesanan(String tipePemesanan) {
		this.tipePemesanan = tipePemesanan;
	}
	
	 @Column(name="PROJEK_CODE") 
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
