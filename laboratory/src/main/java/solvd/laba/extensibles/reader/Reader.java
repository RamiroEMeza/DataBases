package solvd.laba.extensibles.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.entities.facilities.Lab;

import java.io.FileInputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;

public class Reader {
    private final static Logger LOGGER = LogManager.getLogger(Reader.class);
    public static final String LABS_PATH = "../laboratory/src/main/resources/eXtensibles/lab/labs.xml";

    public static void printAllLabs(XMLEventReader r) throws XMLStreamException {
        Lab lab2 = new Lab();
        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                StartElement element = e.asStartElement();
                switch (element.getName().getLocalPart()) {
                    case "lab" -> {
                        Attribute id = element.getAttributeByName(new QName("id"));
                        lab2.setId(Integer.parseInt(id.getValue()));
                    }
                    //LOGGER.info(id.getValue());
                    case "capacity" -> {
                        e = r.nextEvent();
                        if (e.isCharacters()) {
                            lab2.setCapacity(Integer.parseInt(e.asCharacters().getData()));
                        }
                    }
                    //LOGGER.info(Integer.parseInt(e.asCharacters().getData()));
                    case "complexity" -> {
                        e = r.nextEvent();
                        if (e.isCharacters()) {
                            lab2.setComplexity(Integer.parseInt(e.asCharacters().getData()));
                        }
                        // LOGGER.info(Integer.parseInt(e.asCharacters().getData()));
                        LOGGER.info(lab2);
                    }
                    default -> {
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException, XMLStreamException {
        LOGGER.info("--------START--------");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader r = xmlInputFactory.createXMLEventReader(
                new FileInputStream(LABS_PATH));
        printAllLabs(r);

        LOGGER.info("--------END MAIN--------");
    }


}
