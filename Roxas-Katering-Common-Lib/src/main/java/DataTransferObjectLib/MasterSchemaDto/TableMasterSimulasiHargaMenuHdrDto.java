package DataTransferObjectLib.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TableMasterSimulasiHargaMenuHdrDto  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String kodeSimulasi;
    private BigDecimal totalSimulasiAkhir;
    private String kodeMasakan;
    private String notes;
    private Date simulasiTime;
    private Date createdDate;
    private String createdBy;
    private Integer statusAktif;
    private String projekCode;
	public String getKodeSimulasi() {
		return kodeSimulasi;
	}
	public void setKodeSimulasi(String kodeSimulasi) {
		this.kodeSimulasi = kodeSimulasi;
	}
	public BigDecimal getTotalSimulasiAkhir() {
		return totalSimulasiAkhir;
	}
	public void setTotalSimulasiAkhir(BigDecimal totalSimulasiAkhir) {
		this.totalSimulasiAkhir = totalSimulasiAkhir;
	}
	public String getKodeMasakan() {
		return kodeMasakan;
	}
	public void setKodeMasakan(String kodeMasakan) {
		this.kodeMasakan = kodeMasakan;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getSimulasiTime() {
		return simulasiTime;
	}
	public void setSimulasiTime(Date simulasiTime) {
		this.simulasiTime = simulasiTime;
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
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
	}
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
