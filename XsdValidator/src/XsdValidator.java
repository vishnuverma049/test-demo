import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.File; // if you use File
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
public class XsdValidator {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		//QQQQQQQQQQ
		/*try {
			//URL schemaFile = new URL("file:///E:/Airtel/M2M/NewOrder.xsd");
			//DDDDDDDDDDDDDDDD
			File schemaFile = new File("om-postpaid-xml-xsd.xsd"); // etc.
			Source xmlFile = new StreamSource("file:///E:/Airtel/M2M/validate.xml");
			SchemaFactory schemaFactory = SchemaFactory
			    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			try {
			  Schema schema = schemaFactory.newSchema(schemaFile);
			  Validator validator = schema.newValidator();
			  validator.validate(xmlFile);
			  System.out.println(xmlFile.getSystemId() + " is valid");
			} catch (SAXException e) {
			  System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
			} catch (IOException e) {}
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customerOrders>    <customer>        <customerRank>GoldNew</customerRank>        <customerAccount>            <identification>                <id>22274435827238</id>                <type>AccountNumber</type>            </identification>            <accountType>1</accountType>           <parentAccount>                <id></id>            </parentAccount>            <billCycle xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"></billCycle>            <billType>1</billType>            <billMethod>1</billMethod>            <usesAirtelPaymentBank>N</usesAirtelPaymentBank>            <billingAccountSyncFlag></billingAccountSyncFlag>      <lastServiceIDFlag></lastServiceIDFlag>        </customerAccount>        <customerClass>M2M_SELF</customerClass>        <customerType>B2C</customerType>        <customerLanguage>ENG</customerLanguage>        <contactMedium>            <postalAddress>                <addressLine1>356</addressLine1>                <addressLine2>Shahdara, Dps</addressLine2>                <addressLine3>Delhi</addressLine3>                <state>Delhi</state>                <city>New Delhi</city>                <pincode>110099</pincode>                <country>356</country>                <addressType>Billing Address</addressType>            </postalAddress>            <postalAddress>                <addressLine1>356</addressLine1>                <addressLine2>Shahdara, Dps</addressLine2>                <addressLine3>Delhi</addressLine3>                <state>Delhi</state>                <city>New Delhi</city>                <pincode>110099</pincode>                <country>356</country>                <addressType>Local Address</addressType>            </postalAddress>        </contactMedium>        <individual>            <gender></gender>            <nationality></nationality>            <individualName>"+
                "<formofAddress></formofAddress>                <givenNames>Anuj</givenNames>                <familyNames></familyNames>            </individualName>            <contact>                <email>                    <eMailAddress>Neeraj4n43@gmail.com</eMailAddress>                </email>                <telephoneNumber>                    <number>7445627676</number>                    <type>Primary</type>                </telephoneNumber>                <telephoneNumber>                    <type>Alternate</type>                </telephoneNumber>            </contact>        </individual>    </customer>    <customerOrder>        <interactionDate>2017-04-28T12:42:19</interactionDate>        <interactionChannel>M2M</interactionChannel>       <customerOrderType>New</customerOrderType>        <purchaseOrderNumber>M2M-5356</purchaseOrderNumber>        <cafNumber>B2cb2c9901</cafNumber>        <assignedPriority>Medium</assignedPriority>        <orderDate>2017-04-28T12:42:19</orderDate>        <billingAccountNumber>1126118333</billingAccountNumber>       <billingAccountId>1126118333</billingAccountId>        <geographicAddress>            <circle>102</circle>        </geographicAddress>        <revision>1</revision>        <hub>1</hub>        <fulfillmentMode>Deliver</fulfillmentMode>        <createdBy>M2M</createdBy>        <status>UNDER_SIMs_REGISTRATION</status>        <customerOrderSubType>M2M Customer Onboard</customerOrderSubType>        <salesChannelId>11223</salesChannelId>        <salesZone>Del_West_05</salesZone>    </customerOrder></customerOrders>";
		
		InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
		Source xmlFile = new StreamSource(stream);
		SchemaFactory schemaFactory = SchemaFactory
		    .newInstance("http://www.w3.org/2001/XMLSchema");
		try {
			InputStream in = new FileInputStream("om-postpaid-xml-xsd.xsd");
			//String xsd = IOUtils.toString(in);
			  Schema schema = schemaFactory.newSchema(new StreamSource(in));
			  Validator validator = schema.newValidator();
			  validator.validate(xmlFile);
			  System.out.println(xmlFile.getSystemId() + " is valid");
			} catch (SAXException e) {
				System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
				throw new SAXException(e);
			} catch (IOException e) {}
	//}
		
		
		
		 /*System.out.println(xml);
		    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		    domFactory.setNamespaceAware(true);
		    DocumentBuilder builder = domFactory.newDocumentBuilder();
		    Document doc = builder.parse(new InputSource(new StringReader(xml)));
		    XPath xpath = XPathFactory.newInstance().newXPath();
		    xpath.setNamespaceContext(new NamespaceContext() {

		      @Override
		      public Iterator getPrefixes(String arg0) {
		        return null;
		      }

		      @Override
		      public String getPrefix(String arg0) {
		        return null;
		      }

		      @Override
		      public String getNamespaceURI(String arg0) {
		        if ("soapenv".equals(arg0)) {
		          return "http://schemas.xmlsoap.org/soap/envelope/";
		        }
		        return null;
		      }
		    });*/
		
		
      /*  DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
       domFactory.setNamespaceAware(true); 
       DocumentBuilder builder = domFactory.newDocumentBuilder();
       Document doc = builder.parse("file:///E:/Airtel/test.xml");
       XPathFactory factory = XPathFactory.newInstance();
       XPath xpath = factory.newXPath(); 
       xpath.setNamespaceContext(new NamespaceContext() {
		
		@Override
		public Iterator getPrefixes(String namespaceURI) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getPrefix(String namespaceURI) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getNamespaceURI(String prefix) {
			if("ucos".equals(prefix)) {
				return "http://www.airtel.com/aim/schema/updatecustomerorderstatus_V2";
			} else if("tns1".equals(prefix)) {
				return "http://www.airtel.com/aim/schema/abe/customer/customerOrder/v1";
			} else if("tns2".equals(prefix)) {
				return "http://www.airtel.com/aim/schema/abe/commonBusinessEntities/businessInteraction/v1";
			}
			return null;
		}
	});
        XPathExpression fax = xpath.compile("/ucos:updateCustomerOrderStatusReqMsg/ucos:dataArea/ucos:updateCustomerOrderStatus/tns1:customerOrder");
           
                   Object result = fax.evaluate(doc, XPathConstants.NODESET);
        
       NodeList nodes = (NodeList) result;
       int len = nodes.getLength();
       System.out.println(len);
       for (int i=0; i<len;i++){
    	   System.out.println(nodes.item(i).getNodeValue());
    	   Node node = nodes.item(i);
    	   if(node != null && node.getNodeType() == Node.ELEMENT_NODE) {
    		   Element element = (Element) node;
    		   NodeList nodes1 = element.getElementsByTagName("tns2:interactionStatus").item(0).getChildNodes();
   			Node node1 = (Node) nodes1.item(0);
    		   System.out.println(node1.getNodeValue());
    		   
    		   NodeList nodes2 = element.getElementsByTagName("tns1:purchaseOrderNumber").item(0).getChildNodes();
      			Node node2 = (Node) nodes2.item(0);
       		   System.out.println(node2.getNodeValue());
    	   }
       }*/
       }
	}
