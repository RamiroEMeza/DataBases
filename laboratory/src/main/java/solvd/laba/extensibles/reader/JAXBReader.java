package solvd.laba.extensibles.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.entities.equipment.Equipment;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.research.Research;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JAXBReader {
    private final static Logger LOGGER = LogManager.getLogger(JAXBReader.class);
    public static final String EQUIPMENTS_PATH = "../laboratory/src/main/resources/eXtensibles/equipment/equipments.xml";
    public static final String EQUIPMENTS_MARSHAL_PATH = "../laboratory/src/main/resources/eXtensibles/equipment/equipmentsM.xml";
    public static final String ASSISTANTS_PATH = "../laboratory/src/main/resources/eXtensibles/assistant/assistants.xml";
    public static final String RESEARCHES_PATH = "../laboratory/src/main/resources/eXtensibles/research/researches.xml";

    public static Equipment unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Equipment.class);
        return (Equipment) context.createUnmarshaller()
                .unmarshal(new FileReader(EQUIPMENTS_PATH));
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Equipment equipment = new Equipment(200, "Scale", true);

        try {
            File file = new File(EQUIPMENTS_PATH);
            File file2 = new File(EQUIPMENTS_MARSHAL_PATH);

            JAXBContext jaxbContext = JAXBContext.newInstance(Equipment.class);

            Marshaller m = jaxbContext.createMarshaller();
            m.marshal(equipment, file2);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Equipment e = (Equipment) jaxbUnmarshaller.unmarshal(file);
            LOGGER.info("\n");
            LOGGER.info(e);

            e = (Equipment) jaxbUnmarshaller.unmarshal(file2);
            LOGGER.info(e);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            File fileAssistant = new File(ASSISTANTS_PATH);

            JAXBContext jaxbContextAssistant = JAXBContext.newInstance(Assistant.class);

            Unmarshaller jaxbUnmarshaller = jaxbContextAssistant.createUnmarshaller();
            Assistant a = (Assistant) jaxbUnmarshaller.unmarshal(fileAssistant);
            LOGGER.info("\n");
            LOGGER.info(a);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            File fileResearch = new File(RESEARCHES_PATH);

            JAXBContext jaxbContextAssistant = JAXBContext.newInstance(Research.class);

            Unmarshaller jaxbUnmarshaller = jaxbContextAssistant.createUnmarshaller();
            Research r = (Research) jaxbUnmarshaller.unmarshal(fileResearch);
            LOGGER.info("\n");
            LOGGER.info(r);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


        // LOGGER.info(unmarshall());
    }
}
