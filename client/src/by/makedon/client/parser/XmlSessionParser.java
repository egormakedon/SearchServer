package by.makedon.client.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlSessionParser {
    static Logger logger = LogManager.getLogger(XmlSessionParser.class);

    public void parse(File file, List<String> sessionList) {
        final String SESSION = "session";
        final String DATE = "date";
        final String MESSAGE = "message";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();

            Document doc = documentBuilder.newDocument();
            Element rootElement = doc.createElement(SESSION);
            doc.appendChild(rootElement);

            for (String string : sessionList) {
                String[] session = string.split(" ");

                Element date = doc.createElement(DATE);
                date.appendChild(doc.createTextNode(session[0]));
                rootElement.appendChild(date);

                Element message = doc.createElement(MESSAGE);
                message.appendChild(doc.createTextNode(session[1]));
                rootElement.appendChild(message);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(doc);
                StreamResult streamResult = new StreamResult(file);

                transformer.transform(domSource, streamResult);
            }
        } catch (ParserConfigurationException | TransformerConfigurationException e1) {
            logger.log(Level.WARN, e1);
        } catch (TransformerException e1) {
            logger.log(Level.WARN, e1);
        }
    }
}
