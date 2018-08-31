import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.zkoss.zhtml.S;

import CommonLibrary.XmlDatabase.XmlCommonChattingQuery;
import CommonLibrary.XmlDatabase.XmlRepositoryChat;
import DataTransferObject.ChatMessageDtlDto;
import DataTransferObject.ChatMessageHdrDto;

public class AddNewValueXml {
   public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	   ChatMessageDtlDto chatMessageDto = new ChatMessageDtlDto();
	   List<ChatMessageDtlDto> chatMessageDtos = new ArrayList<>();
	   			
				//kalau tidak mau nambah apa-apa
				//writeAllExistingValueXml(dtos, doc.getDocumentElement().getNodeName(),false,false,null,null);	
   
				// kalau mau nambah detail chat di user tertentu
				
				ChatMessageHdrDto chatHeader = new ChatMessageHdrDto();
				chatHeader.setChatTypePerson("PERSONAL");
				chatHeader.setIdPerson("EMP0003");
				chatHeader.setProjekCodePerson("KATERING");
				ChatMessageDtlDto chatDetail = new ChatMessageDtlDto();
				chatDetail.setReceiver("EMP0003");
				chatDetail.setMessage("Hai, EMP0003");
				chatDetail.setMessager("EMP0001");
				chatDetail.setSendDate(new Date());
				chatDetail.setStatusMessage(true);
				Map<String, String> mapTempate = new HashMap<>();
				mapTempate.put("Gambar", "NULL");
				mapTempate.put("Pdf", "NULL");
				mapTempate.put("Word", "NULL");
				chatDetail.setMapTempate(mapTempate);
				List<ChatMessageDtlDto> chatMessageDtlDtos = new ArrayList<>();
				chatMessageDtlDtos.add(chatDetail);
				chatHeader.setChatMessageDtlDtos(chatMessageDtlDtos);
				
				XmlCommonChattingQuery xmlCommonChattingQuery = new XmlCommonChattingQuery();
				//xmlCommonChattingQuery.addNewXml("EMP0001", chatHeader);
   
				
					final File folder = new File("D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileXmls\\ChattingHystory");
					  int count = 0;
					  for (final File fileEntry : folder.listFiles()) {
					        String fileName = deleteWhiteSpace(fileEntry.getName());
					        System.out.println("nama file " + fileName);
					        
					        if(fileName.equalsIgnoreCase("EMP00001.xml"))
				            {
				            	System.err.println("ada file yang sama");
				            }
					    }
				
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
   
   public static void dataTranferObjectChatting(String employeeId, ChatMessageHdrDto chatMessageHdrDto, ChatMessageDtlDto chatMessageDtlDto,
		   String chatXmlCreateFor) {
	   
	   if(chatXmlCreateFor.equalsIgnoreCase("CreateNewXml")){
	    	 createNewChatElement(employeeId, chatMessageHdrDto);
	    	 return;
	   }
	   
	   File fXmlFile = 
			    new File("D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileXmls\\ChattingHystory\\"+employeeId+".xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder;
				try {
					dBuilder = dbFactory.newDocumentBuilder();
					Document doc;
					doc = dBuilder.parse(fXmlFile);	
					doc.getDocumentElement().normalize();
					System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); 	
					List<ChatMessageHdrDto> dtos = readAllExistingValueXml(doc);

					for (ChatMessageHdrDto hdr : dtos) {
						System.out.println(hdr.getIdPerson() + ", " + hdr.getProjekCodePerson()+ ", " + hdr.getChatTypePerson()
						+", " + hdr.getMessageIdPerson());
						for (ChatMessageDtlDto dtl : hdr.getChatMessageDtlDtos()) {
							System.out.println(dtl.getMessage()+" " + dtl.getMessager() + " " + dtl.getSendDate() + " " + dtl.isStatusMessage());
						
						    for (Entry<String, String> map : dtl.getMapTempate().entrySet()) {
								System.out.println( map.getKey()+ " : " + map.getValue());
							}
						}
					}
					
					 if(chatXmlCreateFor.equalsIgnoreCase("AddingChatDetail")) {
				    	 writeAllExistingValueXml
							(dtos, doc.getDocumentElement().getNodeName(), 
									true, false, null, chatMessageDtlDto,employeeId);
				     }
					 else if(chatXmlCreateFor.equalsIgnoreCase("AddingNewPersonChat")) {
						 writeAllExistingValueXml
							(dtos, doc.getDocumentElement().getNodeName(), 
									false, true, chatMessageHdrDto, null,employeeId);
					 }
				} catch (ParserConfigurationException |SAXException | IOException e) {
					e.printStackTrace();
				}
   }
   
   public static void createNewChatElement(String employeeId, ChatMessageHdrDto newChatMessageHdrDto) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element receiver = doc.createElement("CHATROOM-HISTORY");
			doc.appendChild(receiver);

			// subroot person chat with
			Element person1 = doc.createElement("Person");
			Attr id1 = doc.createAttribute("employee-id");
			id1.setValue(newChatMessageHdrDto.getIdPerson());
			person1.setAttributeNode(id1);
			Attr id2 = doc.createAttribute("chat-type");
			id2.setValue(newChatMessageHdrDto.getChatTypePerson());
			person1.setAttributeNode(id2);
			Attr id3 = doc.createAttribute("project-code");
			id3.setValue(newChatMessageHdrDto.getProjekCodePerson());
			person1.setAttributeNode(id3);
			Attr id4 = doc.createAttribute("message-id");
			id4.setValue(newChatMessageHdrDto.getIdPerson()+"K1");
			person1.setAttributeNode(id4);
			receiver.appendChild(person1);

			Element detailHistory = doc.createElement("Detail-History");
			Attr detHisType = doc.createAttribute("detail-Id");
			detHisType.setValue("DETAIL1");
			detailHistory.setAttributeNode(detHisType);
			person1.appendChild(detailHistory);
			
			// carname element
			Element History = doc.createElement("History");
			Attr hisType = doc.createAttribute("type");
			hisType.setValue("Tanggal Kirim");
			History.setAttributeNode(hisType);
			History.appendChild(doc.createTextNode(newChatMessageHdrDto.getChatMessageDtlDtos().get(0).getSendDate().getTime()+""));
			detailHistory.appendChild(History);

			Element History2 = doc.createElement("History");
			Attr hisType2 = doc.createAttribute("type");
			hisType2.setValue("Pengirim");
			History2.setAttributeNode(hisType2);
			History2.appendChild(doc.createTextNode(newChatMessageHdrDto.getChatMessageDtlDtos().get(0).getMessager()));
			detailHistory.appendChild(History2);

			Element History3 = doc.createElement("History");
			Attr hisType3 = doc.createAttribute("type");
			hisType3.setValue("Pesan");
			History3.setAttributeNode(hisType3);
			History3.appendChild(doc.createTextNode(newChatMessageHdrDto.getChatMessageDtlDtos().get(0).getMessage()));
			detailHistory.appendChild(History3);

			Element History4 = doc.createElement("History");
			Attr hisType4 = doc.createAttribute("type");
			hisType4.setValue("Status Pesan");
			History4.setAttributeNode(hisType4);
			History4.appendChild(doc.createTextNode(newChatMessageHdrDto.getChatMessageDtlDtos().get(0).isStatusMessage()+""));
			detailHistory.appendChild(History4);

			Element History5 = doc.createElement("History");
			Attr hisType5 = doc.createAttribute("type");
			hisType5.setValue("Template");
			History5.setAttributeNode(hisType5);

			for (Entry<String, String> temp : newChatMessageHdrDto.getChatMessageDtlDtos().get(0).getMapTempate().entrySet()) {
				Element subHistory1 = doc.createElement("subHistory");
				Attr subHisType1 = doc.createAttribute("type");
				subHisType1.setValue(temp.getKey());
				subHistory1.setAttributeNode(subHisType1);
				subHistory1.appendChild(doc.createTextNode(temp.getValue()));
				History5.appendChild(subHistory1);
			}

			detailHistory.appendChild(History5);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileXmls\\ChattingHystory\\"+employeeId+".xml"));
			transformer.transform(source, result);

			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
   
   public static void writeAllExistingValueXml(List<ChatMessageHdrDto> chatMessageHdrDtos, String rootElement, boolean addDetailChat, 
		   boolean addNewChatter ,ChatMessageHdrDto newChatMessageHdrDto, ChatMessageDtlDto newChatMessageDtlDto, String employeeId) {
	   
	   try {
		   
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
		    
			Element root = doc.createElement(rootElement);
			doc.appendChild(root);
			
			for (ChatMessageHdrDto hdr : chatMessageHdrDtos) {
				Element person1 = doc.createElement("Person");
				Attr id1 = doc.createAttribute("employee-id");
				id1.setValue(hdr.getIdPerson());
				person1.setAttributeNode(id1);
				Attr id2 = doc.createAttribute("chat-type");
				id2.setValue(hdr.getChatTypePerson());
				person1.setAttributeNode(id2);
				Attr id3 = doc.createAttribute("project-code");
				id3.setValue(hdr.getProjekCodePerson());
				person1.setAttributeNode(id3);
				Attr id4 = doc.createAttribute("message-id");
				id4.setValue(hdr.getMessageIdPerson());
				person1.setAttributeNode(id4);
				root.appendChild(person1);
				
				String lastDtl = "";
				for (ChatMessageDtlDto dtl : hdr.getChatMessageDtlDtos()) {
					Element detailHistory = doc.createElement("Detail-History");
					Attr detHisType = doc.createAttribute("detail-Id");
					detHisType.setValue(dtl.getChatDetailId());
					detailHistory.setAttributeNode(detHisType);
					person1.appendChild(detailHistory);
					
					Element History = doc.createElement("History");
					Attr hisType = doc.createAttribute("type");
					hisType.setValue("Tanggal Kirim");
					History.setAttributeNode(hisType);
					History.appendChild(doc.createTextNode(dtl.getSendDate().getTime()+""));
					detailHistory.appendChild(History);

					Element History2 = doc.createElement("History");
					Attr hisType2 = doc.createAttribute("type");
					hisType2.setValue("Pengirim");
					History2.setAttributeNode(hisType2);
					History2.appendChild(doc.createTextNode(dtl.getMessager()));
					detailHistory.appendChild(History2);

					Element History3 = doc.createElement("History");
					Attr hisType3 = doc.createAttribute("type");
					hisType3.setValue("Pesan");
					History3.setAttributeNode(hisType3);
					History3.appendChild(doc.createTextNode(dtl.getMessage()));
					detailHistory.appendChild(History3);

					Element History4 = doc.createElement("History");
					Attr hisType4 = doc.createAttribute("type");
					hisType4.setValue("Status Pesan");
					History4.setAttributeNode(hisType4);
					History4.appendChild(doc.createTextNode(dtl.isStatusMessage()+""));
					detailHistory.appendChild(History4);

					Element History5 = doc.createElement("History");
					Attr hisType5 = doc.createAttribute("type");
					hisType5.setValue("Template");
					History5.setAttributeNode(hisType5);
					
					for (Entry<String, String> temp : dtl.getMapTempate().entrySet()) {
						Element subHistory1 = doc.createElement("subHistory");
						Attr subHisType1 = doc.createAttribute("type");
						subHisType1.setValue(temp.getKey());
						subHistory1.setAttributeNode(subHisType1);
						subHistory1.appendChild(doc.createTextNode(temp.getValue()));
						History5.appendChild(subHistory1);
					}

					detailHistory.appendChild(History5);
					if(addDetailChat) {
					if(newChatMessageDtlDto.getReceiver().equalsIgnoreCase(hdr.getIdPerson())) {
					lastDtl = dtl.getChatDetailId();
					}
					}
				}
				
				if(addDetailChat) {
					if(newChatMessageDtlDto.getReceiver().equalsIgnoreCase(hdr.getIdPerson())) {
				char[] numChar = lastDtl.toCharArray();
			    String numExisting = "";
			    for (int i = 0; i < numChar.length; i++) {
					if(i>5){
						numExisting = numExisting+numChar[i];
					}
				}
				
			    int a = Integer.parseInt(numExisting);
			    int nextDetail = a+1;
			    String finalDetail = "DETAIL"+nextDetail;
				// untuk menambah detail baru buat satu buah employee.
				Element detailHistory = doc.createElement("Detail-History");
				Attr detHisType = doc.createAttribute("detail-Id");
				detHisType.setValue(finalDetail);
				detailHistory.setAttributeNode(detHisType);
				person1.appendChild(detailHistory);
				
				Element History = doc.createElement("History");
				Attr hisType = doc.createAttribute("type");
				hisType.setValue("Tanggal Kirim");
				History.setAttributeNode(hisType);
				History.appendChild(doc.createTextNode((newChatMessageDtlDto.getSendDate().getTime()+"")));
				detailHistory.appendChild(History);

				Element History2 = doc.createElement("History");
				Attr hisType2 = doc.createAttribute("type");
				hisType2.setValue("Pengirim");
				History2.setAttributeNode(hisType2);
				History2.appendChild(doc.createTextNode(newChatMessageDtlDto.getMessager()));
				detailHistory.appendChild(History2);

				Element History3 = doc.createElement("History");
				Attr hisType3 = doc.createAttribute("type");
				hisType3.setValue("Pesan");
				History3.setAttributeNode(hisType3);
				History3.appendChild(doc.createTextNode(newChatMessageDtlDto.getMessage()));
				detailHistory.appendChild(History3);

				Element History4 = doc.createElement("History");
				Attr hisType4 = doc.createAttribute("type");
				hisType4.setValue("Status Pesan");
				History4.setAttributeNode(hisType4);
				History4.appendChild(doc.createTextNode(newChatMessageDtlDto.isStatusMessage()+""));
				detailHistory.appendChild(History4);

				Element History5 = doc.createElement("History");
				Attr hisType5 = doc.createAttribute("type");
				hisType5.setValue("Template");
				History5.setAttributeNode(hisType5);


				for (Entry<String, String> temp : newChatMessageDtlDto.getMapTempate().entrySet()) {
					Element subHistory1 = doc.createElement("subHistory");
					Attr subHisType1 = doc.createAttribute("type");
					subHisType1.setValue(temp.getKey());
					subHistory1.setAttributeNode(subHisType1);
					subHistory1.appendChild(doc.createTextNode(temp.getValue()));
					History5.appendChild(subHistory1);
				}
				
				detailHistory.appendChild(History5);
					}
				}
			}
			
			
			if(addNewChatter) {
			Element person1 = doc.createElement("Person");
			Attr id1 = doc.createAttribute("employee-id");
			id1.setValue(newChatMessageHdrDto.getIdPerson());
			person1.setAttributeNode(id1);
			Attr id2 = doc.createAttribute("chat-type");
			id2.setValue(newChatMessageHdrDto.getChatTypePerson());
			person1.setAttributeNode(id2);
			Attr id3 = doc.createAttribute("project-code");
			id3.setValue(newChatMessageHdrDto.getProjekCodePerson());
			person1.setAttributeNode(id3);
			Attr id4 = doc.createAttribute("message-id");
			String messageId = newChatMessageHdrDto.getIdPerson()+"K1";
			id4.setValue(messageId);
			person1.setAttributeNode(id4);
			root.appendChild(person1);
			
			for (ChatMessageDtlDto dtl : newChatMessageHdrDto.getChatMessageDtlDtos()) {
				Element detailHistory = doc.createElement("Detail-History");
				Attr detHisType = doc.createAttribute("detail-Id");
				detHisType.setValue("DETAIL1");
				detailHistory.setAttributeNode(detHisType);
				person1.appendChild(detailHistory);
				
				Element History = doc.createElement("History");
				Attr hisType = doc.createAttribute("type");
				hisType.setValue("Tanggal Kirim");
				History.setAttributeNode(hisType);
				History.appendChild(doc.createTextNode(dtl.getSendDate().getTime()+""));
				detailHistory.appendChild(History);

				Element History2 = doc.createElement("History");
				Attr hisType2 = doc.createAttribute("type");
				hisType2.setValue("Pengirim");
				History2.setAttributeNode(hisType2);
				History2.appendChild(doc.createTextNode(dtl.getMessager()));
				detailHistory.appendChild(History2);

				Element History3 = doc.createElement("History");
				Attr hisType3 = doc.createAttribute("type");
				hisType3.setValue("Pesan");
				History3.setAttributeNode(hisType3);
				History3.appendChild(doc.createTextNode(dtl.getMessage()));
				detailHistory.appendChild(History3);

				Element History4 = doc.createElement("History");
				Attr hisType4 = doc.createAttribute("type");
				hisType4.setValue("Status Pesan");
				History4.setAttributeNode(hisType4);
				History4.appendChild(doc.createTextNode(dtl.isStatusMessage()+""));
				detailHistory.appendChild(History4);

				Element History5 = doc.createElement("History");
				Attr hisType5 = doc.createAttribute("type");
				hisType5.setValue("Template");
				History5.setAttributeNode(hisType5);
				
				for (Entry<String, String> temp : dtl.getMapTempate().entrySet()) {
					Element subHistory1 = doc.createElement("subHistory");
					Attr subHisType1 = doc.createAttribute("type");
					subHisType1.setValue(temp.getKey());
					subHistory1.setAttributeNode(subHisType1);
					subHistory1.appendChild(doc.createTextNode(temp.getValue()));
					History5.appendChild(subHistory1);
				}

				detailHistory.appendChild(History5);
			}
			
			}
			
			// write the content into xml file
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(
								"D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileXmls\\ChattingHystory\\"+employeeId+".xml"));
						transformer.transform(source, result);

						// Output to console for testing
						StreamResult consoleResult = new StreamResult(System.out);
						transformer.transform(source, consoleResult);
		   
	   }catch (Exception e) {
		e.printStackTrace();
	   }
   }
   
   public static List<ChatMessageHdrDto> readAllExistingValueXml(Document doc){
	   List<ChatMessageHdrDto> chatMessageHdrDtos = new ArrayList<>();
	   doc.getDocumentElement().normalize();
	    NodeList nodeList = doc.getElementsByTagName("Person");
		for (int i = 0; i < nodeList.getLength(); i++) {
			List<ChatMessageDtlDto> chatMessageDtlDtos = new ArrayList<>();
			ChatMessageHdrDto chatMessageHdrDto = new ChatMessageHdrDto();
			Node node = nodeList.item(i);
			chatMessageHdrDto.setIdPerson(node.getAttributes().item(1).getNodeValue());
			chatMessageHdrDto.setProjekCodePerson(node.getAttributes().item(3).getNodeValue());
			chatMessageHdrDto.setChatTypePerson(node.getAttributes().item(0).getNodeValue());
			chatMessageHdrDto.setMessageIdPerson(node.getAttributes().item(2).getNodeValue());
			System.out.println("========= Membaca value dari person dengan id : " 
					+ node.getAttributes().item(0).getNodeValue()+ " ========== ");
		    
			NodeList detailHis = node.getChildNodes();
			for (int j = 0; j < detailHis.getLength(); j++) {
				ChatMessageDtlDto chatMessageDtlDto = new ChatMessageDtlDto();
				Node detailNode = detailHis.item(j);
				chatMessageDtlDto.setChatDetailId(detailNode.getAttributes().item(0).getNodeValue());
				long lo = Long.parseLong(detailNode.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
				chatMessageDtlDto.setSendDate(new Date(lo));
				chatMessageDtlDto.setMessager(detailNode.getChildNodes().item(1).getChildNodes().item(0).getNodeValue());
				chatMessageDtlDto.setMessage(detailNode.getChildNodes().item(2).getChildNodes().item(0).getNodeValue());
				boolean bool = Boolean.parseBoolean(detailNode.getChildNodes().item(3).getChildNodes().item(0).getNodeValue());
				chatMessageDtlDto.setStatusMessage(bool);
				
				Map<String, String> map = new HashMap<>();
				NodeList nlTemplate = detailNode.getChildNodes().item(4).getChildNodes();
				map.put(nlTemplate.item(0).getAttributes().item(0).getNodeValue(), 
						nlTemplate.item(0).getChildNodes().item(0).getNodeValue());
				map.put(nlTemplate.item(1).getAttributes().item(0).getNodeValue(), 
						nlTemplate.item(1).getChildNodes().item(0).getNodeValue());
				map.put(nlTemplate.item(2).getAttributes().item(0).getNodeValue(), 
						nlTemplate.item(2).getChildNodes().item(0).getNodeValue());
				chatMessageDtlDto.setMapTempate(map);
				
				chatMessageDtlDtos.add(chatMessageDtlDto);
			}
			
			chatMessageHdrDto.setChatMessageDtlDtos(chatMessageDtlDtos);
			chatMessageHdrDtos.add(chatMessageHdrDto);
		}
		    
	   return chatMessageHdrDtos;
	   
   }
}
