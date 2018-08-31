import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import java.io.File;

public class ReadXml {
        
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = 
	    new File("D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileXmls\\ChattingHystory\\EMP0001.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		
		NodeList nodeList = doc.getElementsByTagName("Person");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			
			if(node.getAttributes().item(0).getNodeValue().equals("EMP0002")) {
				NodeList subNodeList = node.getChildNodes();
				
				for (int j = 0; j < subNodeList.getLength(); j++) {
					Node subNode = subNodeList.item(j);
					//Element element = (Element) subNode;
			    	//System.out.println("chatroom type : " + element.getAttribute("type"));
					
					
					if(subNode.getAttributes().item(0).getNodeValue().equals("PERSONAL")) {
						NodeList subsubNodeList = subNode.getChildNodes();
						for (int k = 0; k < subsubNodeList.getLength(); k++) {
							Node subSubNode = subsubNodeList.item(k);
							Element element = (Element) subSubNode;
							
							if(subSubNode.getAttributes().item(0).getNodeValue().equals("Template")) {
							   System.out.println( subSubNode.getNodeName() + " " + subSubNode.getAttributes().item(0).getNodeValue()+ " : ");
							   NodeList templateNodeList = subSubNode.getChildNodes();
							   
							   for (int l = 0; l < templateNodeList.getLength(); l++) {
								Node templateNode = templateNodeList.item(l);
								System.out.println(templateNode.getNodeName() + " " + 
								templateNode.getAttributes().item(0).getNodeValue() + " : " + templateNode.getChildNodes().item(0).getNodeValue());
							   }
							   
							}
							else {
							System.out.println( subSubNode.getNodeName() + " " + subSubNode.getAttributes().item(0).getNodeValue() + 
									" : " + subSubNode.getChildNodes().item(0).getNodeValue());
							}
						}
					
					}
					
					
				}
			
			}
			
			
		}
		
    }
}
