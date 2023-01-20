package solvd.laba;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.mysql.EquipmentDAO;
import solvd.laba.equipment.Equipment;
import solvd.laba.facilities.Lab;
import solvd.laba.members.Scientist;
import solvd.laba.research.Research;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    private final static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException, XMLStreamException {
        File equipments = new File("../laboratory/src/main/resources/eXtensibles/equipment/equipments.xml");
        File scientists = new File("../laboratory/src/main/resources/eXtensibles/scientist/scientists.xml");
        File labs = new File("../laboratory/src/main/resources/eXtensibles/lab/labs.xml");
        File researches = new File("../laboratory/src/main/resources/eXtensibles/research/researches.xml");

        XMLEventReader r = XMLInputFactory.newFactory()
                .createXMLEventReader(new FileInputStream(equipments.toString()));

        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
//            if (e.isStartElement()) {
//                //e.asStartElement().getAttributes().forEachRemaining(System.out::println);
//                e.asStartElement().getAttributes().forEachRemaining(a -> System.out.println(a.getName() + " - " + a.getValue()));
//            }
            if (e.isStartElement()) {
////                System.out.println("Event:");
////                System.out.println("toString: " + e);
////                System.out.println("Name: " + e.asStartElement().getName());
                if (e.asStartElement().getName().toString().equals("equipment")) {
                    Equipment equipment = new Equipment();
                    equipment.setId(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("id")).getValue()));
                    equipment.setName(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("name")).getValue()));

                    if (e.asStartElement().getAttributeByName(QName.valueOf("working")).getValue().equals("1")) {
                        equipment.setWorking(true);
                    }
                    LOGGER.info(equipment);
                } else {
                    LOGGER.warn("Element isn't an Equipment");
                }
            }
        }

        r = XMLInputFactory.newFactory()
                .createXMLEventReader(new FileInputStream(scientists.toString()));

        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                if (e.asStartElement().getName().toString().equals("scientist")) {
                    Scientist scientist = new Scientist();
                    scientist.setId(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("id")).getValue()));
                    scientist.setName(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("name")).getValue()));
                    scientist.setLastName(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("lastname")).getValue()));
                    scientist.setNationality(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("nationality")).getValue()));
                    scientist.setAge(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("age")).getValue()));
                    LOGGER.info(scientist);
                } else {
                    LOGGER.warn("Element isn't a Scientist");
                }
            }
        }

        r = XMLInputFactory.newFactory()
                .createXMLEventReader(new FileInputStream(labs.toString()));

        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                if (e.asStartElement().getName().toString().equals("lab")) {
                    Lab lab = new Lab();
                    lab.setId(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("id")).getValue()));
                    lab.setCapacity(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("capacity")).getValue()));
                    lab.setComplexity(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("complexity")).getValue()));
                    LOGGER.info(lab);
                } else {
                    LOGGER.warn("Element isn't a Lab");
                }
            }
        }

        r = XMLInputFactory.newFactory()
                .createXMLEventReader(new FileInputStream(researches.toString()));
        Research research = new Research();
        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                if (e.asStartElement().getName().toString().equals("research")) {
                    research.setId(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("id")).getValue()));
                    research.setName(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("name")).getValue()));
                    research.setBudget(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("budget")).getValue()));
                    if (e.asStartElement().getAttributeByName(QName.valueOf("complete")).getValue().equals("1")) {
                        research.setComplete(true);
                    }
                } else if (e.asStartElement().getName().toString().equals("lab")) {
                    Lab lab = new Lab();
                    lab.setId(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("id")).getValue()));
                    lab.setCapacity(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("capacity")).getValue()));
                    lab.setComplexity(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("complexity")).getValue()));
                    research.setLab(lab);
                } else if (e.asStartElement().getName().toString().equals("scientist")) {
                    Scientist scientist = new Scientist();
                    scientist.setId(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("id")).getValue()));
                    scientist.setName(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("name")).getValue()));
                    scientist.setLastName(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("lastname")).getValue()));
                    scientist.setNationality(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("nationality")).getValue()));
                    scientist.setAge(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("age")).getValue()));
                    research.setScientist(scientist);
                    LOGGER.info(research);
                } else {
                    LOGGER.warn("Element isn't a Research");
                }
            }
        }
    }
}
