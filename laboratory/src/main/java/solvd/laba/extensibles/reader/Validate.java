package solvd.laba.extensibles.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import solvd.laba.Main;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.IOException;

import static org.apache.commons.io.FileUtils.getFile;

public class Validate {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    private static final String ASSISTANTS_XSD = "./src/main/resources/eXtensibles/assistant/assistants.xsd";
    private static final String ASSISTANTS_XML = "./src/main/resources/eXtensibles/assistant/assistants.xml";

    private static final String EQUIPMENT_XSD = "./src/main/resources/eXtensibles/equipment/equipment.xsd";
    private static final String EQUIPMENT_XML = "./src/main/resources/eXtensibles/equipment/equipments.xml";

    private static final String LABS_XSD = "./src/main/resources/eXtensibles/lab/labs.xsd";
    private static final String LABS_XML = "./src/main/resources/eXtensibles/lab/labs.xml";

    private static final String RESEARCH_XSD = "./src/main/resources/eXtensibles/research/researches.xsd";
    private static final String RESEARCH_XML = "./src/main/resources/eXtensibles/research/researches.xml";

    private static final String SCIENTIST_XSD = "./src/main/resources/eXtensibles/scientist/scientists.xsd";
    private static final String SCIENTIST_XML = "./src/main/resources/eXtensibles/scientist/scientists.xml";

    private static Validator initValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(getFile(xsdPath));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }

    public static boolean isValid(String xsdPath, String xmlPath) throws IOException, SAXException {
        Validator validator = initValidator(xsdPath);
        try {
            validator.validate(new StreamSource(getFile(xmlPath)));
            return true;
        } catch (SAXException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            LOGGER.info("Validating assistants.xml: " + isValid(ASSISTANTS_XSD, ASSISTANTS_XML));
            LOGGER.info("Validating equipment.xml: " + isValid(EQUIPMENT_XSD, EQUIPMENT_XML));
            LOGGER.info("Validating labs.xml: " + isValid(LABS_XSD, LABS_XML));
            LOGGER.info("Validating scientist.xml: " + isValid(SCIENTIST_XSD, SCIENTIST_XML));
            LOGGER.info("Validating researches.xml: " + isValid(RESEARCH_XSD, RESEARCH_XML));
        } catch (IOException e) {
            LOGGER.error("IOException" + e.getMessage());
        } catch (SAXException e) {
            LOGGER.error("SAXException" + e.getMessage());
        }

    }
}
