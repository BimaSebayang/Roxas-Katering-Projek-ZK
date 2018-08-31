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

import entity.KateringSchema.entityKateringPk.TableTrxPemesananDtlPk;


@Entity
@Table(name = "KATERING.TABLE_TRX_PEMESANAN_DTL")
@IdClass(TableTrxPemesananDtlPk.class)
public class TableTrxPemesananDtl {
    private String kodePemesananDtl;
    private String kodeMakanan;
    private String kodeSimulasi;
    private String kodePemesanan;
    private String kodePajak;
    private BigDecimal hargaPesananFinal;
    private String kodeProses;
    private String kodeDeliver;
    private BigDecimal hargaAdminDeliver;
    private BigDecimal hargaPengiriman;
    private Integer statusAktif;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private BigDecimal hargaAkhir;
    private String projekCode;
    
    
    @Id
    @Column(name="KODE_PEMESANAN_DTL") 
	public String getKodePemesananDtl() {
		return kodePemesananDtl;
	}
	public void setKodePemesananDtl(String kodePemesananDtl) {
		this.kodePemesananDtl = kodePemesananDtl;
	}
	
	@Column(name="KODE_MAKANAN") 
	public String getKodeMakanan() {
		return kodeMakanan;
	}
	public void setKodeMakanan(String kodeMakanan) {
		this.kodeMakanan = kodeMakanan;
	}
	
	@Column(name="KODE_SIMULASI") 
	public String getKodeSimulasi() {
		return kodeSimulasi;
	}
	public void setKodeSimulasi(String kodeSimulasi) {
		this.kodeSimulasi = kodeSimulasi;
	}
	
	@Column(name="KODE_PEMESANAN") 
	public String getKodePemesanan() {
		return kodePemesanan;
	}
	public void setKodePemesanan(String kodePemesanan) {
		this.kodePemesanan = kodePemesanan;
	}
	
	@Column(name="KODE_PAJAK") 
	public String getKodePajak() {
		return kodePajak;
	}
	public void setKodePajak(String kodePajak) {
		this.kodePajak = kodePajak;
	}
	
	@Column(name="HARGA_PESANAN_FINAL") 
	public BigDecimal getHargaPesananFinal() {
		return hargaPesananFinal;
	}
	public void setHargaPesananFinal(BigDecimal hargaPesananFinal) {
		this.hargaPesananFinal = hargaPesananFinal;
	}
	
	@Column(name="KODE_PROSES") 
	public String getKodeProses() {
		return kodeProses;
	}
	public void setKodeProses(String kodeProses) {
		this.kodeProses = kodeProses;
	}
	
	@Column(name="KODE_DELIVER") 
	public String getKodeDeliver() {
		return kodeDeliver;
	}
	public void setKodeDeliver(String kodeDeliver) {
		this.kodeDeliver = kodeDeliver;
	}
	
	@Column(name="HARGA_ADMIN_DELIVER") 
	public BigDecimal getHargaAdminDeliver() {
		return hargaAdminDeliver;
	}
	public void setHargaAdminDeliver(BigDecimal hargaAdminDeliver) {
		this.hargaAdminDeliver = hargaAdminDeliver;
	}
	
	@Column(name="HARGA_PENGIRIMAN") 
	public BigDecimal getHargaPengiriman() {
		return hargaPengiriman;
	}
	public void setHargaPengiriman(BigDecimal hargaPengiriman) {
		this.hargaPengiriman = hargaPengiriman;
	}
	
	@Column(name="STATUS_AKTIF") 
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
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
	
	@Column(name="HARGA_AKHIR") 
	public BigDecimal getHargaAkhir() {
		return hargaAkhir;
	}
	public void setHargaAkhir(BigDecimal hargaAkhir) {
		this.hargaAkhir = hargaAkhir;
	}
	
	@Column(name="PROJEK_CODE") 
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
