package DataTransferObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatMessageDtlDto implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String chatDetailId;
   private Map<String, String> mapTempate = new HashMap<>();
   private String message;
   private String messager;
   private boolean onGroupChat;
   private List<String> personTag = new ArrayList<>();
   private String receiver;
   private Date sendDate;
   private boolean statusMessage;
   private byte[] template;
   private byte[] templates;
public String getChatDetailId() {
	return chatDetailId;
}
public void setChatDetailId(String chatDetailId) {
	this.chatDetailId = chatDetailId;
}
public Map<String, String> getMapTempate() {
	return mapTempate;
}
public void setMapTempate(Map<String, String> mapTempate) {
	this.mapTempate = mapTempate;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getMessager() {
	return messager;
}
public void setMessager(String messager) {
	this.messager = messager;
}
public boolean isOnGroupChat() {
	return onGroupChat;
}
public void setOnGroupChat(boolean onGroupChat) {
	this.onGroupChat = onGroupChat;
}
public List<String> getPersonTag() {
	return personTag;
}
public void setPersonTag(List<String> personTag) {
	this.personTag = personTag;
}
public String getReceiver() {
	return receiver;
}
public void setReceiver(String receiver) {
	this.receiver = receiver;
}
public Date getSendDate() {
	return sendDate;
}
public void setSendDate(Date sendDate) {
	this.sendDate = sendDate;
}
public boolean isStatusMessage() {
	return statusMessage;
}
public void setStatusMessage(boolean statusMessage) {
	this.statusMessage = statusMessage;
}
public byte[] getTemplate() {
	return template;
}
public void setTemplate(byte[] template) {
	this.template = template;
}
public byte[] getTemplates() {
	return templates;
}
public void setTemplates(byte[] templates) {
	this.templates = templates;
}
}
