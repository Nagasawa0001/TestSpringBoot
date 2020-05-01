package core.io.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OutputXML {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// InputXML.javaと同じ流れで必要なインスタンスを生成
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		// createElementでElementを生成（<info>）
		Element info = doc.createElement("info");
		// Elementにオプションを付与する（<info code="codeValue">）
		info.setAttribute("code", "codeValue");
		// 作成してあるDOM Treeに反映させる（最上階層）
		doc.appendChild(info);

		// createElementでElementを生成（<books>）
		Element books = doc.createElement("books");
		// <info>の下の階層に<books>を配置する
		info.appendChild(books);

		// createElementでElementを生成（<title>）
		Element name = doc.createElement("title");
		// <title></title>の中にテキストを挿入する（<title>titleeeeeeeeeeeee</title>）
		name.appendChild(doc.createTextNode("titleeeeeeeeeee"));
		books.appendChild(name);


		// createElementでElementを生成（<category>）
		Element category = doc.createElement("category");
		category.appendChild(doc.createTextNode("categoryyyyyyyyyy"));
		books.appendChild(category);

		// XMLを整形して出力する（準備）
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();

		// DOMSource ⇨  NodeTreeをセット、StreamResult ⇨ ファイル型のパスをURI型に変換後、String型(US-ASCII型)に変換している
		// XMLファイルを出力
		tf.transform(new DOMSource(doc), new StreamResult(new File("src/main/resources/io/output/output.xml")));
		}
}
