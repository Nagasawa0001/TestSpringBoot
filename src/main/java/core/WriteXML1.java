package core;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML1 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		Element info = doc.createElement("info");
		info.setAttribute("code", "codeValue");
		doc.appendChild(info);

		Element books = doc.createElement("books");
		info.appendChild(books);
		Element name = doc.createElement("title");
		name.appendChild(doc.createTextNode("titleeeeeeeeeee"));
		books.appendChild(name);
		Element category = doc.createElement("category");
		category.appendChild(doc.createTextNode("categoryyyyyyyyyy"));
		books.appendChild(category);

		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult(new File("src/main/resources/outputFile2.xml")));


		}
}
