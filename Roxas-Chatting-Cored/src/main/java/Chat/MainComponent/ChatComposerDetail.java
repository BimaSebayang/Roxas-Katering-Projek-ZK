package Chat.MainComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zul.Messagebox;

import com.mysql.fabric.xmlrpc.base.Data;

import DataTransferObject.ChatMessageDtlDto;
import DataTransferObject.ChatMessageHdrDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ChatComposerDetail extends ChatComposer{

	private static final long serialVersionUID = 1L;
	private List<TableUserDto> collectAllUserOnline = new ArrayList<>();
	private TableUserDto tableUserDto = new TableUserDto();
	private String currentUser = "";
	private TableUserDto selectedUserChat = new TableUserDto();
	private String chatPhrase = new String();
	private List<String> chatPhrases = new ArrayList<>();
    private int i = 1;
    private List<ChatMessageDtlDto> chatMessageDtlDtos = new ArrayList<>();
    private ChatMessageDtlDto chatMessageDtlDto = new ChatMessageDtlDto();

	@Command("timerUpdater")
	public void testTimer() {
		init();
		initAllChat();
	}
	
	@Command("chatPerson")
	public void chatPerson() {
		onChatDeployer(true, false);
	}
	
	public void initAllChat() {
	   String collector1 = "Pengirim " + collectUserOnline().getPegawaiId() + " Penerima " + selectedUserChat.getPegawaiId();
	   chatMessageDtlDtos = (List<ChatMessageDtlDto>) initDesktop().getWebApp().getAttribute(collector1);
	   BindUtils.postNotifyChange(null, null, this, "chatMessageDtlDtos");
	}
	
	@Command("sendChat")
	public void sendChat(){
		String collector1 = "Pengirim " + collectUserOnline().getPegawaiId() + " Penerima " + selectedUserChat.getPegawaiId();
		String collector2 = "Pengirim " + selectedUserChat.getPegawaiId() + " Penerima " + collectUserOnline().getPegawaiId();
		chatMessageDtlDto = new ChatMessageDtlDto();
		chatMessageDtlDto.setMessage(chatPhrase);
		chatMessageDtlDto.setSendDate(new Date());
		chatMessageDtlDto.setMessager(collectUserOnline().getPegawaiName());
		chatMessageDtlDto.setReceiver(selectedUserChat.getPegawaiId());
		chatMessageDtlDto.setStatusMessage(true);
		chatMessageDtlDto.setOnGroupChat(false);
		Map<String, String> mapTempate = new HashMap<>();
		mapTempate.put("Gambar", "NULL");
		mapTempate.put("Pdf", "NULL");
		mapTempate.put("Word", "NULL");
		chatMessageDtlDto.setMapTempate(mapTempate);
		if(chatMessageDtlDtos == null) {
			chatMessageDtlDtos = new ArrayList<>();
		}
		chatMessageDtlDtos.add(chatMessageDtlDto);
		
		//addition particle --start
		List<ChatMessageDtlDto> dtlHistReceiver = new ArrayList<>();
		ChatMessageDtlDto receiver = new ChatMessageDtlDto();
		receiver.setMessage(chatPhrase);
		receiver.setSendDate(new Date());
		receiver.setMessager(collectUserOnline().getPegawaiName());
		receiver.setReceiver(collectUserOnline().getPegawaiId());
		receiver.setStatusMessage(true);
		receiver.setOnGroupChat(false);
		receiver.setMapTempate(mapTempate);
		dtlHistReceiver.add(receiver);
		//addition particle --end
		
		//insertToChatHistory(collectUserOnline().getPegawaiId(), selectedUserChat.getPegawaiId());
		BindUtils.postNotifyChange(null, null, this, "chatMessageDtlDtos");
		chatPhrase = "";
		BindUtils.postNotifyChange(null, null, this, "chatPhrase");
		initDesktop().getWebApp().setAttribute(collector1,chatMessageDtlDtos);
		initDesktop().getWebApp().setAttribute(collector2,chatMessageDtlDtos);
		List<ChatMessageDtlDto> dtlHist = new ArrayList<>();
		dtlHist.add(chatMessageDtlDto);
		insertToChatHistory(collectUserOnline().getPegawaiId(),selectedUserChat.getPegawaiId(),dtlHist);
		insertToChatHistory(selectedUserChat.getPegawaiId(),collectUserOnline().getPegawaiId(),dtlHistReceiver);
	}
	
	public void insertToChatHistory(String currentUser, String selectedUser, List<ChatMessageDtlDto> messageDtlDtos) {
		ChatMessageHdrDto chatHeader = new ChatMessageHdrDto();
		chatHeader.setChatTypePerson("PERSONAL");
		chatHeader.setIdPerson(selectedUser);
		chatHeader.setProjekCodePerson("KATERING");
		chatHeader.setChatMessageDtlDtos(messageDtlDtos);
			chatHistory(currentUser, selectedUser, chatHeader);
	}
	
	
	@Init(superclass = true)
	public void init() {
		collectAllUserOnline = (List<TableUserDto>) initDesktop().getWebApp().getAttribute("collectAll");
		if(collectAllUserOnline==null) {
			collectAllUserOnline = new ArrayList<>();
			collectAllUserOnline.add(collectUserOnline());
			initDesktop().getWebApp().setAttribute("collectAll",collectAllUserOnline);
		}
		else {
		    //initDesktop().enableServerPush(true);
		    List<String> users = new ArrayList<>();
		    for (TableUserDto list : collectAllUserOnline) {
				users.add(list.getPegawaiId());
			}
		    if(!users.contains(collectUserOnline().getPegawaiId())) {
			    collectAllUserOnline.add(collectUserOnline());
		    }
		}
		currentUser = collectUserOnline().getPegawaiId();
		BindUtils.postNotifyChange(null, null, this, "currentUser");
	    BindUtils.postNotifyChange(null, null, this, "collectAllUserOnline");
	}
	
	public List<TableUserDto> getCollectAllUserOnline() {
		return collectAllUserOnline;
	}

	public void setCollectAllUserOnline(List<TableUserDto> collectAllUserOnline) {
		this.collectAllUserOnline = collectAllUserOnline;
	}

	public TableUserDto getTableUserDto() {
		return tableUserDto;
	}

	public void setTableUserDto(TableUserDto tableUserDto) {
		this.tableUserDto = tableUserDto;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public TableUserDto getSelectedUserChat() {
		return selectedUserChat;
	}

	public void setSelectedUserChat(TableUserDto selectedUserChat) {
		this.selectedUserChat = selectedUserChat;
	}

	public String getChatPhrase() {
		return chatPhrase;
	}

	public void setChatPhrase(String chatPhrase) {
		this.chatPhrase = chatPhrase;
	}

	public List<String> getChatPhrases() {
		return chatPhrases;
	}

	public void setChatPhrases(List<String> chatPhrases) {
		this.chatPhrases = chatPhrases;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public List<ChatMessageDtlDto> getChatMessageDtlDtos() {
		return chatMessageDtlDtos;
	}

	public void setChatMessageDtlDtos(List<ChatMessageDtlDto> chatMessageDtlDtos) {
		this.chatMessageDtlDtos = chatMessageDtlDtos;
	}

	public ChatMessageDtlDto getChatMessageDtlDto() {
		return chatMessageDtlDto;
	}

	public void setChatMessageDtlDto(ChatMessageDtlDto chatMessageDtlDto) {
		this.chatMessageDtlDto = chatMessageDtlDto;
	}




	
	

}
