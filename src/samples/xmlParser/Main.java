package samples.xmlParser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws XPathExpressionException,
			SAXException, IOException, ParserConfigurationException {

		// 1-1. xml 문서 입력하기
		// String xml =
		// "<root><row><col1 id='c1'>값1</col1><col2 id='c2' val='val2'>값2</col2></row>"
		// + "<row><col1 id='c3'>값3</col1><col2 id='c4'>값4</col2></row></root>";
		// // XML Document 객체 생성
		// InputSource is = new InputSource(new StringReader(xml));
		// Document document = DocumentBuilderFactory.newInstance()
		// .newDocumentBuilder().parse(is);

		// 1-2. 인터넷 상의 XML 문서 가져오기
		Document document = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse("https://play.watcha.net/subtitles/2c9f949e5e7b0f7b01616f4599142304.xml?lang=en");

		// 2-1. xpath 생성
		XPath xpath = XPathFactory.newInstance().newXPath();

		NodeList cols = (NodeList) xpath.evaluate("//body/div/p", document,
				XPathConstants.NODESET);
		for (int idx = 0; idx < cols.getLength(); idx++) {
			System.out.println(cols.item(idx).getTextContent());
		}
		
//		// 3-1. NodeList 가져오기 : row 아래에 있는 모든 col1 을 선택
//		NodeList cols = (NodeList) xpath.evaluate("//row/col1", document,
//				XPathConstants.NODESET);
//		for (int idx = 0; idx < cols.getLength(); idx++) {
//			System.out.println(cols.item(idx).getTextContent());
//		}
//		// 값1 값3 이 출력됨
//
//		// 3-2. id 가 c2 인 Node의 val attribute 값 가져오기
//		Node col2 = (Node) xpath.evaluate("//*[@id='c2']", document,
//				XPathConstants.NODE);
//		System.out.println(col2.getAttributes().getNamedItem("val")
//				.getTextContent());
//		// val2 출력
//
//		// 3-3. id 가 c3 인 Node 의 value 값 가져오기
//		System.out.println(xpath.evaluate("//*[@id='c3']", document,
//				XPathConstants.STRING));
//		// 값3 출력
	}

}
