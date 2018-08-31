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

import entity.MasterSchema.entityMasterPk.TableMasterSimulasiHargaMenuHdrPk;


@Entity
@Table(name = "MASTER.TABLE_MASTER_SIMULASI_HARGA_MENU_HDR")
@IdClass(TableMasterSimulasiHargaMenuHdrPk.class)
public class TableMasterSimulasiHargaMenuHdr {
    private String kodeSimulasi;
    private BigDecimal totalSimulasiAkhir;
    private String kodeMasakan;
    private String notes;
    private Date simulasiTime;
    private Date createdDate;
    private String createdBy;
    private Integer statusAktif;
    private String projekCode;
    
    @Id
	@Column(name = "KODE_SIMULASI")
	public String getKodeSimulasi() {
		return kodeSimulasi;
	}
	public void setKodeSimulasi(String kodeSimulasi) {
		this.kodeSimulasi = kodeSimulasi;
	}
	
	@Column(name = "TOTAL_SIMULASI_AKHIR")
	public BigDecimal getTotalSimulasiAkhir() {
		return totalSimulasiAkhir;
	}
	public void setTotalSimulasiAkhir(BigDecimal totalSimulasiAkhir) {
		this.totalSimulasiAkhir = totalSimulasiAkhir;
	}
	
	@Column(name = "KODE_MASAKAN")
	public String getKodeMasakan() {
		return kodeMasakan;
	}
	public void setKodeMasakan(String kodeMasakan) {
		this.kodeMasakan = kodeMasakan;
	}
	
	
	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Column(name = "SIMULASI_TIME")
	@Temporal(TemporalType.DATE)
	public Date getSimulasiTime() {
		return simulasiTime;
	}
	public void setSimulasiTime(Date simulasiTime) {
		this.simulasiTime = simulasiTime;
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
	
	@Column(name = "STATUS_AKTIF")
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
	}
	
	@Column(name = "PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
    
}
