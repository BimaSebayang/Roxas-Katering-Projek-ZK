package entity.MasterSchema;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.MasterSchema.entityMasterPk.TableMasterProsedurformDtlPk;

@Entity
@Table(name = "MASTER.TABLE_MASTER_PROSEDURFORM_DTL")
@IdClass(TableMasterProsedurformDtlPk.class)
public class TableMasterProsedurformDtl {
	private String prosedurIdDetail;
	private String prosedurId;
	private String detailName;
	private String urlDetailPicture;
	private Integer prosedurSeq;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private String projekCode;

	@Id
	@Column(name = "PROSEDUR_ID_DETAIL")
	public String getProsedurIdDetail() {
		return prosedurIdDetail;
	}

	public void setProsedurIdDetail(String prosedurIdDetail) {
		this.prosedurIdDetail = prosedurIdDetail;
	}

	@Column(name = "PROSEDUR_ID")
	public String getProsedurId() {
		return prosedurId;
	}

	public void setProsedurId(String prosedurId) {
		this.prosedurId = prosedurId;
	}

	@Column(name = "DETAIL_NAME")
	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	@Column(name = "URL_DETAIL_PICTURE")
	public String getUrlDetailPicture() {
		return urlDetailPicture;
	}

	public void setUrlDetailPicture(String urlDetailPicture) {
		this.urlDetailPicture = urlDetailPicture;
	}

	@Column(name = "PROSEDUR_SEQ")
	public Integer getProsedurSeq() {
		return prosedurSeq;
	}

	public void setProsedurSeq(Integer prosedurSeq) {
		this.prosedurSeq = prosedurSeq;
	}

	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}

	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}

}
