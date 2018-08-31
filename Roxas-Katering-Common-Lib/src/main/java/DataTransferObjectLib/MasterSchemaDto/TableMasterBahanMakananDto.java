package DataTransferObjectLib.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TableMasterBahanMakananDto  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String kodeBahan;
	private String namaBahan;
	private String kodeResep;
	private BigDecimal hargaBahan;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private Integer statusAktif;
	private String statusApproval;
	private String projekCode;
	public String getKodeBahan() {
		return kodeBahan;
	}
	public void setKodeBahan(String kodeBahan) {
		this.kodeBahan = kodeBahan;
	}
	public String getNamaBahan() {
		return namaBahan;
	}
	public void setNamaBahan(String namaBahan) {
		this.namaBahan = namaBahan;
	}
	public String getKodeResep() {
		return kodeResep;
	}
	public void setKodeResep(String kodeResep) {
		this.kodeResep = kodeResep;
	}
	public BigDecimal getHargaBahan() {
		return hargaBahan;
	}
	public void setHargaBahan(BigDecimal hargaBahan) {
		this.hargaBahan = hargaBahan;
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
