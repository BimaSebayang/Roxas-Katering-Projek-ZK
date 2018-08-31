package DataTransferObjectLib.MassageSchemaDto;

import java.io.Serializable;
import java.util.Date;


public class TableApprovalMessageDtlDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String messageDtlId;
	private String messageId;
	private String approvalPerson;
	private Date approvalDate;
	private Integer approvalSequence;
    private String resultStatusApproval;
    private String createdBy;
    private Date createdDate;
    private String notes;
    private String projekCode;
    private String namaKaryawan;
    private String menuName;
    private String urlMenuApproval;
    private TableApprovalMessageHdrDto tableApprovalMessageHdrDto = new TableApprovalMessageHdrDto();
    
    
	public TableApprovalMessageHdrDto getTableApprovalMessageHdrDto() {
		return tableApprovalMessageHdrDto;
	}
	public void setTableApprovalMessageHdrDto(TableApprovalMessageHdrDto tableApprovalMessageHdrDto) {
		this.tableApprovalMessageHdrDto = tableApprovalMessageHdrDto;
	}
	public String getMessageDtlId() {
		return messageDtlId;
	}
	public void setMessageDtlId(String messageDtlId) {
		this.messageDtlId = messageDtlId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getApprovalPerson() {
		return approvalPerson;
	}
	public void setApprovalPerson(String approvalPerson) {
		this.approvalPerson = approvalPerson;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public Integer getApprovalSequence() {
		return approvalSequence;
	}
	public void setApprovalSequence(Integer approvalSequence) {
		this.approvalSequence = approvalSequence;
	}
	public String getResultStatusApproval() {
		return resultStatusApproval;
	}
	public void setResultStatusApproval(String resultStatusApproval) {
		this.resultStatusApproval = resultStatusApproval;
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
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrlMenuApproval() {
		return urlMenuApproval;
	}
	public void setUrlMenuApproval(String urlMenuApproval) {
		this.urlMenuApproval = urlMenuApproval;
	}
    
    
}
