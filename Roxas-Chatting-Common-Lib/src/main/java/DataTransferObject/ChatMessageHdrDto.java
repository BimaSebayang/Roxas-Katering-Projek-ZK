package DataTransferObject;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageHdrDto {
   private List<ChatMessageDtlDto> chatMessageDtlDtos = new ArrayList<>();
   private String chatTypePerson;
   private String idPerson;
   private String messageIdPerson;
   private String projekCodePerson;
public List<ChatMessageDtlDto> getChatMessageDtlDtos() {
	return chatMessageDtlDtos;
}
public void setChatMessageDtlDtos(List<ChatMessageDtlDto> chatMessageDtlDtos) {
	this.chatMessageDtlDtos = chatMessageDtlDtos;
}
public String getChatTypePerson() {
	return chatTypePerson;
}
public void setChatTypePerson(String chatTypePerson) {
	this.chatTypePerson = chatTypePerson;
}
public String getIdPerson() {
	return idPerson;
}
public void setIdPerson(String idPerson) {
	this.idPerson = idPerson;
}
public String getMessageIdPerson() {
	return messageIdPerson;
}
public void setMessageIdPerson(String messageIdPerson) {
	this.messageIdPerson = messageIdPerson;
}
public String getProjekCodePerson() {
	return projekCodePerson;
}
public void setProjekCodePerson(String projekCodePerson) {
	this.projekCodePerson = projekCodePerson;
}
}
