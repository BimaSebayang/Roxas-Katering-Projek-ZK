import java.io.File;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXml {
	public static void main(String argv[]) {

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
			id1.setValue("EMP0002");
			person1.setAttributeNode(id1);
			Attr id2 = doc.createAttribute("chat-type");
			id2.setValue("PERSONAL");
			person1.setAttributeNode(id2);
			Attr id3 = doc.createAttribute("project-code");
			id3.setValue("KATERING");
			person1.setAttributeNode(id3);
			Attr id4 = doc.createAttribute("message-id");
			id4.setValue("EMP0002K1");
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
			History.appendChild(doc.createTextNode((new Date()).getTime()+""));
			detailHistory.appendChild(History);

			Element History2 = doc.createElement("History");
			Attr hisType2 = doc.createAttribute("type");
			hisType2.setValue("Pengirim");
			History2.setAttributeNode(hisType2);
			History2.appendChild(doc.createTextNode("EMP002"));
			detailHistory.appendChild(History2);

			Element History3 = doc.createElement("History");
			Attr hisType3 = doc.createAttribute("type");
			hisType3.setValue("Pesan");
			History3.setAttributeNode(hisType3);
			History3.appendChild(doc.createTextNode("Hai Bim, Apa kabar? baikkan? :-) "));
			detailHistory.appendChild(History3);

			Element History4 = doc.createElement("History");
			Attr hisType4 = doc.createAttribute("type");
			hisType4.setValue("Status Pesan");
			History4.setAttributeNode(hisType4);
			History4.appendChild(doc.createTextNode("TRUE"));
			detailHistory.appendChild(History4);

			Element History5 = doc.createElement("History");
			Attr hisType5 = doc.createAttribute("type");
			hisType5.setValue("Template");
			History5.setAttributeNode(hisType5);

			Element subHistory1 = doc.createElement("subHistory");
			Attr subHisType1 = doc.createAttribute("type");
			subHisType1.setValue("Gambar");
			subHistory1.setAttributeNode(subHisType1);
			subHistory1.appendChild(doc.createTextNode("NULL"));
			History5.appendChild(subHistory1);

			Element subHistory2 = doc.createElement("subHistory");
			Attr subHisType2 = doc.createAttribute("type");
			subHisType2.setValue("Pdf");
			subHistory2.setAttributeNode(subHisType2);
			subHistory2.appendChild(doc.createTextNode("NULL"));
			History5.appendChild(subHistory2);

			Element subHistory3 = doc.createElement("subHistory");
			Attr subHisType3 = doc.createAttribute("type");
			subHisType3.setValue("Word");
			subHistory3.setAttributeNode(subHisType3);
			subHistory3.appendChild(doc.createTextNode("NULL"));
			History5.appendChild(subHistory3);

			detailHistory.appendChild(History5);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileXmls\\ChattingHystory\\EMP0001.xml"));
			transformer.transform(source, result);

			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
