import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.net.URL;

public class SOAPClientSAAJ {

    public static void main(String args[]) {
        try {
            SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = sfc.createConnection();

            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage sm = mf.createMessage();

            SOAPHeader sh = sm.getSOAPHeader();
            SOAPBody sb = sm.getSOAPBody();
            sh.detachNode();
            QName bodyName = new QName("http://viaphone.us/soap", "lookupRequest", XMLConstants.DEFAULT_NS_PREFIX);
            SOAPBodyElement bodyElement = sb.addBodyElement(bodyName);
            bodyElement.addAttribute(new QName("purchaseId"), "1");

            System.out.println("\n Soap Request:\n");
            sm.writeTo(System.out);
            System.out.println();

            URL endpoint = new URL("http://192.168.10.69:8082/soap/");
            SOAPMessage response = connection.call(sm, endpoint);
            printSOAPResponse(response);
            System.out.println(response.getContentDescription());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }
}