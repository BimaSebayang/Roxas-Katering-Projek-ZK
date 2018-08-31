package DataTransferObjectLib.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DataTransferObjectLib.CommonDto;

public class TableMasterProsedurformHdrDto extends CommonDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String prosedurId;
	private String prosedurName;
	private String menuCode;
	private Integer totalProsedur;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private Integer statusAktif;
    private String statusApproval;
    private String menuReferensi;
    private String statusPersetujuan;
    private String statusProsedur;
    private String projekCode;
    
    private List<String> prosedurIds = new ArrayList<>();
    private List<String> prosedurNames = new ArrayList<>();
    private List<String> menuReferensis = new ArrayList<>();
    private List<BigDecimal> totalProsedurs = new ArrayList<>();
    private List<String> statusPersetujuans = new ArrayList<>();
    private List<String> statusProsedurs = new ArrayList<>();
    
    private List<TableMasterProsedurformDtlDto> tableMasterProsedurformDtlDtos = new ArrayList<>();
    
	public String getStatusProsedur() {
		return statusProsedur;
	}


	public void setStatusProsedur(String statusProsedur) {
		this.statusProsedur = statusProsedur;
	}


	public List<String> getProsedurIds() {
		return prosedurIds;
	}


	public void setProsedurIds(List<String> prosedurIds) {
		this.prosedurIds = prosedurIds;
	}


	public List<String> getProsedurNames() {
		return prosedurNames;
	}


	public void setProsedurNames(List<String> prosedurNames) {
		this.prosedurNames = prosedurNames;
	}


	public List<String> getMenuReferensis() {
		return menuReferensis;
	}


	public void setMenuReferensis(List<String> menuReferensis) {
		this.menuReferensis = menuReferensis;
	}


	


	public List<BigDecimal> getTotalProsedurs() {
		return totalProsedurs;
	}


	public void setTotalProsedurs(List<BigDecimal> totalProsedurs) {
		this.totalProsedurs = totalProsedurs;
	}


	public List<String> getStatusPersetujuans() {
		return statusPersetujuans;
	}


	public void setStatusPersetujuans(List<String> statusPersetujuans) {
		this.statusPersetujuans = statusPersetujuans;
	}


	public List<String> getStatusProsedurs() {
		return statusProsedurs;
	}


	public void setStatusProsedurs(List<String> statusProsedurs) {
		this.statusProsedurs = statusProsedurs;
	}


	public String getStatusPersetujuan() {
		return statusPersetujuan;
	}


	public void setStatusPersetujuan(String statusPersetujuan) {
		this.statusPersetujuan = statusPersetujuan;
	}


	public String getMenuReferensi() {
		return menuReferensi;
	}


	public void setMenuReferensi(String menuReferensi) {
		this.menuReferensi = menuReferensi;
	}


	public String getProsedurId() {
		return prosedurId;
	}


	public void setProsedurId(String prosedurId) {
		this.prosedurId = prosedurId;
	}


	public String getProsedurName() {
		return prosedurName;
	}


	public void setProsedurName(String prosedurName) {
		this.prosedurName = prosedurName;
	}






	public String getMenuCode() {
		return menuCode;
	}






	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}






	public Integer getTotalProsedur() {
		return totalProsedur;
	}






	public void setTotalProsedur(Integer totalProsedur) {
		this.totalProsedur = totalProsedur;
	}






	public String getCreatedBy() {
		return createdBy;
	}






	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}






	public Date getCreatedDate() {
		return createdDate;
	}






	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}






	public String getUpdatedBy() {
		return updatedBy;
	}






	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}






	public Date getUpdatedDate() {
		return updatedDate;
	}






	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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






	@Override
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	public String getProjekCode() {
		return projekCode;
	}


	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}


	public List<TableMasterProsedurformDtlDto> getTableMasterProsedurformDtlDtos() {
		return tableMasterProsedurformDtlDtos;
	}


	public void setTableMasterProsedurformDtlDtos(List<TableMasterProsedurformDtlDto> tableMasterProsedurformDtlDtos) {
		this.tableMasterProsedurformDtlDtos = tableMasterProsedurformDtlDtos;
	}
}
