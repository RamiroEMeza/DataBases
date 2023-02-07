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
    public static final String EQUIPMENTS_PATH = "laboratory/src/main/resources/eXtensibles/equipment/equipments.xml";
    public static final String EQUIPMENTS_MARSHAL_PATH = "laboratory/src/main/resources/eXtensibles/equipment/equipmentsM.xml";
    public static final String ASSISTANTS_PATH = "laboratory/src/main/resources/eXtensibles/assistant/assistants.xml";
    public static final String RESEARCHES_PATH = "../laboratory/src/main/resources/eXtensibles/research/researches.xml";

    public static Equipment unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Equipment.class);
        return (Equipment) context.createUnmarshaller()
                .unmarshal(new FileReader(EQUIPMENTS_PATH));
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Equipment equipment = new Equipment(200, "Scale", true);
        File equipments = new File(EQUIPMENTS_PATH);
        File fileAssistant = new File(ASSISTANTS_PATH);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Equipment.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File writeEquipment = new File(EQUIPMENTS_MARSHAL_PATH);
            marshaller.marshal(equipment, writeEquipment);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Equipment e = (Equipment) jaxbUnmarshaller.unmarshal(equipments);
            LOGGER.info("\n");
            LOGGER.info(e);

            e = (Equipment) jaxbUnmarshaller.unmarshal(writeEquipment);
            LOGGER.info(e);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext jaxbContextAssistant = JAXBContext.newInstance(Assistant.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextAssistant.createUnmarshaller();
            Assistant a = (Assistant) jaxbUnmarshaller.unmarshal(fileAssistant);
            LOGGER.info("\n");
            LOGGER.info(a);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
