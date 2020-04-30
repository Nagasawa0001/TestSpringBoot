package core;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML1 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		InputStream is = new FileInputStream("src/main/resources/TestInfo.xml");
		System.out.println(is);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(is);
		Element element = doc.getDocumentElement();

		NodeList nodeList = element.getChildNodes();

		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element name = (Element)node;
				name.setTextContent("eeeeee");
				System.out.println(name.getTextContent());
			}

		}



	}

}
