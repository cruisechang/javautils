package com.cruise.utils.asset;

import com.cruise.finals.ErrorFinal;


//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtil {

	public static Element xmlLoader(String xmlFile) {
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
			InputStream is = new FileInputStream(xmlFile);
			Document doc = dombuilder.parse(is);
			Element root = doc.getDocumentElement();
			return root;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return (Element) ErrorFinal.ERROR_OBJECT;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return (Element) ErrorFinal.ERROR_OBJECT;
		} catch (SAXException e) {
			e.printStackTrace();
			return (Element) ErrorFinal.ERROR_OBJECT;
		} catch (IOException e) {
			e.printStackTrace();
			return (Element) ErrorFinal.ERROR_OBJECT;
		}
	}
	
	

}
