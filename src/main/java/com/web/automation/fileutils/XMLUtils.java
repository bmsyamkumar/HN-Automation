package com.web.automation.fileutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SuppressWarnings("deprecation")
public class XMLUtils {

	/**
	 * @param args
	 */

	public static void writeXmlFile(Document doc, String filename) {
		try {
			// Prepare the DOM document for writing
			Source source = new DOMSource(doc);

			// Prepare the output file
			File file = new File(filename);
			Result result = new StreamResult(file);

			// Write the DOM document to the file
			Transformer xformer = TransformerFactory.newInstance()
			.newTransformer();
			xformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
		} catch (TransformerException e) {
		}
	}

	//set data from XML using attributeID and element name in that particular node
	public  void setData(String file, String id, String subNode,
			String data) {
		try {
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = df.newDocumentBuilder();
			Document doc = db.parse(file);

			String xpath_temp = "//*[@id='" + id + "']";
			String xpath = xpath_temp + "//" + subNode;
			NodeList nodelist = org.apache.xpath.XPathAPI.selectNodeList(doc,
					xpath);
			Node element = nodelist.item(0);
			element.setTextContent(data);
			//Writing data to XML file
			writeXmlFile(doc, file);

		} catch (Exception exception) {
			System.out.println(exception.getMessage());

		}
	}

	//set data from XML using attributeID and element name in that particular node
	public  void setData(String file, String xpath, String data) {
			try {
				DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = df.newDocumentBuilder();
				Document doc = db.parse(file);

				
				//xpath = xpath_temp + "//" + subNode;
				NodeList nodelist = org.apache.xpath.XPathAPI.selectNodeList(doc,
						xpath);
				Node element = nodelist.item(0);
				element.setTextContent(data);
				//Writing data to XML file
				writeXmlFile(doc, file);

			} catch (Exception exception) {
				System.out.println(exception.getMessage());

			}
		}
		
	//get data from XML using attributeID and element name in that particular node
	public  String getData(Document doc, String id, String subNode) {

		Node element = null;
		String xpath_temp = "//*[@id='" + id + "']";
		String xpath = xpath_temp + "//" + subNode;
		NodeList nodelist;
		try {
			nodelist = org.apache.xpath.XPathAPI.selectNodeList(doc,xpath);
			element = nodelist.item(0);
		} catch (TransformerException e) {
			e.getLocalizedMessage();
		}

		//System.out.println("String :" + element.getTextContent());
		return element.getTextContent();
	}
	
	//Get data from xpath
	//If the xpath return a list, then this function returns the first one
	public  String getData(Document doc, String xpath) throws TransformerException {

		Node element = null;
		NodeList nodelist;
		nodelist = org.apache.xpath.XPathAPI.selectNodeList(doc,xpath);
		element = nodelist.item(0);
		return element.getTextContent();
	}

	//Get Document object for a file
	public  Document getDocObject(String filename) throws IOException {

		//create a DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//create a DocumentBuilder
		DocumentBuilder db;
		try {

			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(filename));
                                
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} 
		return null;
	}

	//Creating an Empty DOM Document
	public  Document createDomDocument() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.newDocument();
			return doc;
		} catch (ParserConfigurationException e) {
		}
		return null;
	}

	//Print the doc object to a file
	public  void printToFile(Document doc,String sFile) throws IOException{

		//print
		OutputFormat format = new OutputFormat(doc);
		format.setIndenting(true);

		//to generate output to console use this serializer
		//XMLSerializer serializer = new XMLSerializer(System.out, format);


		//to generate a file output use fileoutputstream instead of system.out
		FileOutputStream fo = new FileOutputStream(new File(sFile));
		XMLSerializer serializer = new XMLSerializer(fo, format);

		serializer.serialize(doc);
		fo.close();
	}
	
	//Generate the OutputXML document object
	public  Document generateOutputXML(boolean bResult) {

		//Create outputXML object
		Document xOutputDoc = createDomDocument();
		Element root = xOutputDoc.createElement("TestResult");
		Element result = xOutputDoc.createElement("Result");
		
		if(bResult)
			result.setTextContent("Passed");
		else
			result.setTextContent("Failed");
		
		root.appendChild(result);
		xOutputDoc.appendChild(root);
		return xOutputDoc;
	}
	
	//Get data using xpath 
	public  List<String> getNodeNames(Document doc, String xpath) throws TransformerException {

		List<String> sList = new LinkedList<String>();
		sList = new ArrayList<String>();

		NodeList nodelist;
		nodelist = org.apache.xpath.XPathAPI.selectNodeList(doc,xpath);
		// Process the elements in the nodelist
        for (int i=0; i<nodelist.getLength(); i++) {
         // Get element
           Element elem = (Element)nodelist.item(i);
           sList.add(elem.getNodeName());
        }
		return sList;
	}
	
	/**
	 * @param doc - The XML file to get values from
	 * @param xpath - The XPath to get values
	 * @return A list with the node values
	 * @throws TransformerException
	 */
	public  List<String> getNodeValues(Document doc, String xpath) throws TransformerException {

		List<String> sList = new LinkedList<String>();
		sList = new ArrayList<String>();

		NodeList nodelist;
		nodelist = org.apache.xpath.XPathAPI.selectNodeList(doc,xpath);
		// Process the elements in the nodelist
        for (int i=0; i<nodelist.getLength(); i++) {
         // Get element
           Element elem = (Element)nodelist.item(i);
           sList.add(elem.getTextContent());
        }
		return sList;
	}
	
	//Get data using xpath 
	public  Map<String, String> getNode_Data(Document doc, String xpath) throws TransformerException {

		Map<String, String> mElementData = new HashMap<String, String>();

		NodeList nodelist;
		nodelist = org.apache.xpath.XPathAPI.selectNodeList(doc,xpath);
		// Process the elements in the nodelist
        for (int i=0; i<nodelist.getLength(); i++) {
         // Get element
           Element elem = (Element)nodelist.item(i);
           mElementData.put(elem.getNodeName(),elem.getTextContent());
        }
		return mElementData;
	}
	
	
	public static void main(String[] args) throws IOException, TransformerException {
		
		//Document doc = getDocObject("D:/Hashching/Hashching/testng_xmls/testdata.xml");
		//List<String> list = getNodeNames(doc, "//username");
		/*
		for(String name:list)
			System.out.println(name);
		*/
        XMLUtils xmlU = new XMLUtils();
		xmlU.setData("D:\\Hashching\\Hashching\\testdata\\BrokersCase1.xml","//testdata1/firstname","newTestFirstName");
		//System.out.println("password: "+getData(doc, "//password"));
	}

}
