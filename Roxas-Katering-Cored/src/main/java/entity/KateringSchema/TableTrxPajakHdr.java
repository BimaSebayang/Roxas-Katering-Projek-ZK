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

import entity.KateringSchema.entityKateringPk.TableTrxPajakHdrPk;

@Entity
@Table(name = "KATERING.TABLE_TRX_PAJAK_HDR")
@IdClass(TableTrxPajakHdrPk.class)
public class TableTrxPajakHdr {
	private String kodePajak;
	private BigDecimal varTarifPajak1;
	private Integer flagNpwp;
	private BigDecimal varTarifPajak2;
	private Integer countLateYear;
	private BigDecimal varTarifPajak3;
	private Integer flagPajakDaerah;
	private BigDecimal varTarifPajak4;
	private BigDecimal varTarifPajakTambahan;
	private String kodeMakanan;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private Integer status;
	private String statusApproval;
	private String projekCode;

	
	@Id
    @Column(name="KODE_PAJAK") 
	public String getKodePajak() {
		return kodePajak;
	}

	public void setKodePajak(String kodePajak) {
		this.kodePajak = kodePajak;
	}

	@Column(name="VAR_TARIF_PAJAK1") 
	public BigDecimal getVarTarifPajak1() {
		return varTarifPajak1;
	}

	public void setVarTarifPajak1(BigDecimal varTarifPajak1) {
		this.varTarifPajak1 = varTarifPajak1;
	}

	@Column(name="FLAG_NPWP") 
	public Integer getFlagNpwp() {
		return flagNpwp;
	}

	public void setFlagNpwp(Integer flagNpwp) {
		this.flagNpwp = flagNpwp;
	}

	@Column(name="VAR_TARIF_PAJAK2") 
	public BigDecimal getVarTarifPajak2() {
		return varTarifPajak2;
	}

	public void setVarTarifPajak2(BigDecimal varTarifPajak2) {
		this.varTarifPajak2 = varTarifPajak2;
	}

	@Column(name="COUNT_LATE_YEAR") 
	public Integer getCountLateYear() {
		return countLateYear;
	}

	public void setCountLateYear(Integer countLateYear) {
		this.countLateYear = countLateYear;
	}

	@Column(name="VAR_TARIF_PAJAK3") 
	public BigDecimal getVarTarifPajak3() {
		return varTarifPajak3;
	}

	public void setVarTarifPajak3(BigDecimal varTarifPajak3) {
		this.varTarifPajak3 = varTarifPajak3;
	}

	@Column(name="FLAG_PAJAK_DAERAH") 
	public Integer getFlagPajakDaerah() {
		return flagPajakDaerah;
	}

	public void setFlagPajakDaerah(Integer flagPajakDaerah) {
		this.flagPajakDaerah = flagPajakDaerah;
	}

	@Column(name="VAR_TARIF_PAJAK4") 
	public BigDecimal getVarTarifPajak4() {
		return varTarifPajak4;
	}

	public void setVarTarifPajak4(BigDecimal varTarifPajak4) {
		this.varTarifPajak4 = varTarifPajak4;
	}

	@Column(name="VAR_TARIF_PAJAK_TAMBAHAN") 
	public BigDecimal getVarTarifPajakTambahan() {
		return varTarifPajakTambahan;
	}

	public void setVarTarifPajakTambahan(BigDecimal varTarifPajakTambahan) {
		this.varTarifPajakTambahan = varTarifPajakTambahan;
	}

	@Column(name="KODE_MAKANAN") 
	public String getKodeMakanan() {
		return kodeMakanan;
	}

	public void setKodeMakanan(String kodeMakanan) {
		this.kodeMakanan = kodeMakanan;
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

	@Column(name="STATUS") 
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	@Column(name="STATUS_APPROVAL") 
	public String getStatusApproval() {
		return statusApproval;
	}

	public void setStatusApproval(String statusApproval) {
		this.statusApproval = statusApproval;
	}

	@Column(name="PROJEK_CODE") 
	public String getProjekCode() {
		return projekCode;
	}

	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}

}
