package DataTransferObjectLib.MasterSchemaDto;

import java.io.Serializable;
import java.util.Date;

import DataTransferObjectLib.CommonDto;

public class TableMasterProsedurformDtlDto extends CommonDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String prosedurIdDetail;
	private String prosedurId;
	private String detailName;
	private String urlDetailPicture;
	private Integer prosedurSeq;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
    private byte[] detailGambar;
	
	
	public byte[] getDetailGambar() {
		return detailGambar;
	}



	public void setDetailGambar(byte[] detailGambar) {
		this.detailGambar = detailGambar;
	}



	public String getProsedurIdDetail() {
		return prosedurIdDetail;
	}



	public void setProsedurIdDetail(String prosedurIdDetail) {
		this.prosedurIdDetail = prosedurIdDetail;
	}



	public String getProsedurId() {
		return prosedurId;
	}



	public void setProsedurId(String prosedurId) {
		this.prosedurId = prosedurId;
	}



	public String getDetailName() {
		return detailName;
	}



	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}



	public String getUrlDetailPicture() {
		return urlDetailPicture;
	}



	public void setUrlDetailPicture(String urlDetailPicture) {
		this.urlDetailPicture = urlDetailPicture;
	}



	public Integer getProsedurSeq() {
		return prosedurSeq;
	}



	public void setProsedurSeq(Integer prosedurSeq) {
		this.prosedurSeq = prosedurSeq;
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



	@Override
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
}
