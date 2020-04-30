package core.io.xml;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class InputXML {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// XMLファイルの読み込み
		InputStream is = new FileInputStream("src/main/resources/io/input/input.xml");
		System.out.println(is);

		// 必要なインスタンスを生成
		// DocumentBuilderFactory から DocumentBuilderのインスタンスを生成
		// DocumentBuilder から Documentのインスタンスを生成
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(is);

		// 最上位階層のElementノードを取得(<root>を取得)
		Element element = doc.getDocumentElement();

		// <root>の子要素を取得（<books>）してリストに格納
		NodeList nodeList = element.getChildNodes();

		for(int i = 0; i < nodeList.getLength(); i++) {
			// リストからノードを取得(1. 空白行、2.<books>, 3.空白行)
			Node node = nodeList.item(i);

			// NodeTypeが「1」の場合に処理を行う（1はエレメント<books> 3は空白行）
			//※NodeListをループ処理する場合、エレメントの前後は空白行になる
			if(node.getNodeType() == Node.ELEMENT_NODE) {

				// <books>の中の<book1><book2>を取得してリストに格納
				NodeList tempBooks = node.getChildNodes();
				for(int j = 0; j < tempBooks.getLength(); j++) {

					// リストからノードを取得（1.空白行、2.<book1>、3.空白行、4.<book2>、5.空白行）
					Node node2 = tempBooks.item(j);

					// NodeTypeが「1」の場合に処理を行う（1はエレメント<books> 3は空白行）
					if(node2.getNodeType() == Node.ELEMENT_NODE) {

						// ノードの名前(book1 or book2)を取得
						System.out.println(node2.getNodeName());

						// ノードのテキスト内容を取得
						System.out.println("Context : " + node2.getTextContent());
					}
				}
			}
		}
	}
}
