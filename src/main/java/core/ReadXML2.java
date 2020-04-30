package core;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML2 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		// XMLファイルの読み込み
		InputStream is = new FileInputStream("src/main/resources/TestInfo2.xml");
		System.out.println(is);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(is);

		// 最上位階層のElementノードを取得(<root>を取得)
		Element element = doc.getDocumentElement();

		// <root>の子要素を取得（<books>）してリストに格納
		NodeList nodeList = element.getChildNodes();

		for(int i = 0; i < nodeList.getLength(); i++) {
			// リストからノードを取得
			Node node = nodeList.item(i);

			// NodeTypeが「1」の場合に処理を行う（1はエレメント<books> 3は空白行）
			//※NodeListをループ処理する場合、エレメントの前後は空白行になる
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				//Element books = (Element)node;
				System.out.println(node.getNodeName());
				NodeList tempBooks = node.getChildNodes();
				for(int j = 0; j < tempBooks.getLength(); j++) {
					Node node2 = tempBooks.item(j);
					if(node2.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(node2.getNodeName());
						System.out.println("Context : " + node2.getTextContent());
					}
				}
			}

		}



	}

}
