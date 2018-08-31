package CommonLibrary.XmlDatabase;

import DataTransferObject.ChatMessageDtlDto;
import DataTransferObject.ChatMessageHdrDto;

public class XmlCommonChattingQuery extends XmlRepositoryChat{
     
	 public void addNewXml(String employeeId, ChatMessageHdrDto chatMessageHdrDto) {
		 dataTranferObjectChatting(employeeId, chatMessageHdrDto, null, "CreateNewXml"); 
     }
	 
	 public void insertNewChatDetail(String employeeId, ChatMessageDtlDto chatMessageDtlDto) {
		dataTranferObjectChatting(employeeId, null, chatMessageDtlDto, "AddingChatDetail"); 
	 }
	 
	 public void insertNewPersonChat(String employeeId, ChatMessageHdrDto chatMessageHdrDto) {
		 dataTranferObjectChatting(employeeId, chatMessageHdrDto, null, "AddingNewPersonChat");
	 }
	 
	 public boolean isExistNewChatter(String employeeId, String chatter) {
		 if(countExistingPersonXml(employeeId, chatter)==0) {
			 return true;
		 }
		 return false;
	 }
	 
}
