package Chat.MainComponent;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timer;
import org.zkoss.zul.Window;

import CommonLibrary.XmlDatabase.XmlCommonChattingQuery;
import DataTransferObject.ChatMessageHdrDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;

/**
 * @author Richard Lovell
 * Main composer for the chat application.
 */


public class ChatComposer extends GenericForwardComposer {
 
	protected boolean onChatPerson = false;
	protected boolean onChatGroup = false;
	protected Desktop chatDesktop;
	
	public TableUserDto tableUserDto = new TableUserDto();
	
	public void onChatDeployer(boolean onChatPerson, boolean onChatGroup) {
		this.onChatGroup = onChatGroup;
		this.onChatPerson = onChatPerson;
		BindUtils.postNotifyChange(null, null, this, "onChatGroup");
		BindUtils.postNotifyChange(null, null, this, "onChatPerson");
	}
	
	public void chatHistory(String employeeId, String selectedUserChatting,ChatMessageHdrDto chatMessageHdrDto) {
		//Messagebox.show("Chat Terbentuk");
		XmlCommonChattingQuery xmlQuery = new XmlCommonChattingQuery();
		if (!isExistFileName(employeeId)) {
			//Messagebox.show("File Xml Terbentuk baru");
			xmlQuery.addNewXml(employeeId, chatMessageHdrDto);
			return;
		}
		
		if (xmlQuery.isExistNewChatter(employeeId, selectedUserChatting)) {
			//Messagebox.show("Ada User Baru Yang Dichat");
			xmlQuery.insertNewPersonChat(employeeId, chatMessageHdrDto);
			return;
		}
		    //Messagebox.show("Ada Chat Baru Yang Ditambahkan");
		    xmlQuery.insertNewChatDetail(employeeId, chatMessageHdrDto.getChatMessageDtlDtos().get(0));
			return;
	}
	
	public boolean isExistFileName(String employeeId){
		final File folder = new File("D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileXmls\\ChattingHystory");
		  int count = 0;
		  for (final File fileEntry : folder.listFiles()) {
			  String fileName = deleteWhiteSpace(fileEntry.getName());
		            if(fileName.equals(employeeId+".xml"))
		            {
		            	return true;
		            }
		    }
		  return false;
	}
	
	public static String deleteWhiteSpace(String word) {
		   char[] wordInChar = word.toCharArray();
		   String finalStr = "";
		   for (int i = 0; i < wordInChar.length; i++) {
			   String detector = Character.toString(wordInChar[i]);
			   finalStr = finalStr + detector.trim();
		   }
		   return finalStr;
	   }
	
	public TableUserDto collectUserOnline(){
		Map<String, Object> mapp = (Map<String, Object>) Sessions.getCurrent().getAttribute("TransferUserInformation");
		if(mapp==null) {
			 Executions.sendRedirect("/");	
			 return new TableUserDto();
		}
		tableUserDto.setUserId(((String) mapp.get("userId")).trim());
		tableUserDto.setProjekCode(((String) mapp.get("projekCode")).trim());
		tableUserDto.setStatus((int) mapp.get("status"));
		tableUserDto.setPegawaiId(((String) mapp.get("pegawaiId")).trim());
		tableUserDto.setPegawaiName(((String) mapp.get("pegawaiName")).trim());
		
//		tableUserDto.setUserId("bimaSS");
//		tableUserDto.setProjekCode("KATERING");
//		tableUserDto.setStatus(1);
//		tableUserDto.setPegawaiId("EMP0001");
//		tableUserDto.setPegawaiName("BIMA SATRYA SEBAYANG");
		
		return tableUserDto;
	}
	
	public Desktop initDesktop() {
		return Executions.getCurrent().getDesktop();
	}

	public Desktop getChatDesktop() {
		return chatDesktop;
	}

	public void setChatDesktop(Desktop chatDesktop) {
		this.chatDesktop = chatDesktop;
	}

	public TableUserDto getTableUserDto() {
		return tableUserDto;
	}

	public void setTableUserDto(TableUserDto tableUserDto) {
		this.tableUserDto = tableUserDto;
	}
	
	public boolean isOnChatPerson() {
		return onChatPerson;
	}

	public void setOnChatPerson(boolean onChatPerson) {
		this.onChatPerson = onChatPerson;
	}

	public boolean isOnChatGroup() {
		return onChatGroup;
	}

	public void setOnChatGroup(boolean onChatGroup) {
		this.onChatGroup = onChatGroup;
	}
}
