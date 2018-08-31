package DataTransferObjectLib;

import java.io.Serializable;

import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageDtlDto;
import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageHdrDto;

public class CommonDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String messageId;
	protected TableApprovalMessageDtlDto tableApprovalMessageDtl;
	protected TableApprovalMessageHdrDto tableApprovalMessageHdr;
	
	

	public TableApprovalMessageDtlDto getTableApprovalMessageDtl() {
		return tableApprovalMessageDtl;
	}

	public void setTableApprovalMessageDtl(TableApprovalMessageDtlDto tableApprovalMessageDtl) {
		this.tableApprovalMessageDtl = tableApprovalMessageDtl;
	}

	public TableApprovalMessageHdrDto getTableApprovalMessageHdr() {
		return tableApprovalMessageHdr;
	}

	public void setTableApprovalMessageHdr(TableApprovalMessageHdrDto tableApprovalMessageHdr) {
		this.tableApprovalMessageHdr = tableApprovalMessageHdr;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}
