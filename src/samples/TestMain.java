package samples;

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

public class TestMain {
	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException, XPathExpressionException {

		String id = "2c9f949e5e7b0f7b0161c6b0913b2700";

		Document document = DocumentBuilderFactory
				.newInstance()
				.newDocumentBuilder()
				.parse("https://play.watcha.net/subtitles/" + id
						+ ".xml?lang=en");

		// 2-1. xpath 생성
		XPath xpath = XPathFactory.newInstance().newXPath();

		NodeList cols = (NodeList) xpath.evaluate("//body/div/p", document,
				XPathConstants.NODESET);
		for (int idx = 0; idx < cols.getLength(); idx++) {
			System.out.println(cols.item(idx).getTextContent());
		}

	}
}
