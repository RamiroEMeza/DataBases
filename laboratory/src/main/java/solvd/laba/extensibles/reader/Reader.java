package solvd.laba.extensibles.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.entities.equipment.Equipment;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;
import solvd.laba.entities.research.Research;

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
    public static final String EQUIPMENTS_PATH = "../laboratory/src/main/resources/eXtensibles/equipment/equipments.xml";
    public static final String SCIENTISTS_PATH = "../laboratory/src/main/resources/eXtensibles/scientist/scientists.xml";
    public static final String ASSISTANTS_PATH = "../laboratory/src/main/resources/eXtensibles/assistant/assistants.xml";
    public static final String LABS_PATH = "../laboratory/src/main/resources/eXtensibles/lab/labs.xml";
    public static final String RESEARCHES_PATH = "../laboratory/src/main/resources/eXtensibles/research/researches.xml";

    public static void printAllLabs(XMLEventReader r) throws XMLStreamException {
        Lab lab2 = new Lab();
        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                StartElement element = e.asStartElement();
                switch (element.getName().getLocalPart()) {
                    case "lab":
                        Attribute id = element.getAttributeByName(new QName("id"));
                        lab2.setId(Integer.parseInt(id.getValue()));
                        //LOGGER.info(id.getValue());
                        break;
                    case "capacity":
                        e = r.nextEvent();
                        if (e.isCharacters()) {
                            lab2.setCapacity(Integer.parseInt(e.asCharacters().getData()));
                        }
                        //LOGGER.info(Integer.parseInt(e.asCharacters().getData()));
                        break;
                    case "complexity":
                        e = r.nextEvent();
                        if (e.isCharacters()) {
                            lab2.setComplexity(Integer.parseInt(e.asCharacters().getData()));
                        }
                        // LOGGER.info(Integer.parseInt(e.asCharacters().getData()));
                        LOGGER.info(lab2);
                        break;
                    default:
                        break;
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

//        public static void printAllEquipments(XMLEventReader r) throws XMLStreamException {
//        while (r.hasNext()) {
//            XMLEvent e = r.nextEvent();
//            if (e.isStartElement()) {
//                StartElement element = e.asStartElement();
//                if (element.getName().getLocalPart().equals("equipment")) {
//                    Equipment equipment = new Equipment();
//
//                    Attribute id = element.getAttributeByName(new QName("id"));
//                    Attribute name = element.getAttributeByName(new QName("name"));
//                    Attribute working = element.getAttributeByName(new QName("working"));
//                    equipment.setId(Integer.parseInt(id.getValue()));
//                    equipment.setName(name.getValue());
//                    if (working.getValue().equals("1")) {
//                        equipment.setWorking(true);
//                    }
//                    LOGGER.info(equipment);
//                } else {
//                    LOGGER.warn("\nElement isn't an Equipment");
//                }
//            }
//        }
//    }
//
//    public static void printAllScientists(XMLEventReader r) throws XMLStreamException {
//        while (r.hasNext()) {
//            XMLEvent e = r.nextEvent();
//            if (e.isStartElement()) {
//                StartElement element = e.asStartElement();
//                if (element.getName().getLocalPart().equals("scientist")) {
//                    Scientist scientist = new Scientist();
//                    Attribute id = element.getAttributeByName(new QName("id"));
//                    Attribute name = element.getAttributeByName(new QName("name"));
//                    Attribute lastName = element.getAttributeByName(new QName("lastname"));
//                    Attribute nationality = element.getAttributeByName(new QName("nationality"));
//                    Attribute age = element.getAttributeByName(new QName("age"));
//                    scientist.setId(Integer.parseInt(id.getValue()));
//                    scientist.setName(name.getValue());
//                    scientist.setLastName(lastName.getValue());
//                    scientist.setNationality(nationality.getValue());
//                    scientist.setAge(Integer.parseInt(age.getValue()));
//                    LOGGER.info(scientist);
//                } else {
//                    LOGGER.warn("\nElement isn't a Scientist");
//                }
//            }
//        }
//    }
//
//    public static void printAllResearches(XMLEventReader r) throws XMLStreamException {
//        Research research = new Research();
//        while (r.hasNext()) {
//            XMLEvent e = r.nextEvent();
//            if (e.isStartElement()) {
//                StartElement element = e.asStartElement();
//                if (e.asStartElement().getName().toString().equals("research")) {
//                    Attribute id = element.getAttributeByName(new QName("id"));
//                    Attribute name = element.getAttributeByName(new QName("name"));
//                    Attribute budget = element.getAttributeByName(new QName("budget"));
//                    Attribute complete = element.getAttributeByName(new QName("complete"));
//                    research.setId(Integer.parseInt(id.getValue()));
//                    research.setName(name.getValue());
//                    research.setBudget(Integer.parseInt(budget.getValue()));
//                    if (complete.getValue().equals("1")) {
//                        research.setComplete(true);
//                    }
//                } else if (e.asStartElement().getName().toString().equals("lab")) {
//                    Lab lab = new Lab();
//                    Attribute id = element.getAttributeByName(new QName("id"));
//                    Attribute capacity = element.getAttributeByName(new QName("capacity"));
//                    Attribute complexity = element.getAttributeByName(new QName("complexity"));
//                    lab.setId(Integer.parseInt(id.getValue()));
//                    lab.setCapacity(Integer.parseInt(capacity.getValue()));
//                    lab.setComplexity(Integer.parseInt(complexity.getValue()));
//                    research.setLab(lab);
//                } else if (e.asStartElement().getName().toString().equals("scientist")) {
//                    Scientist scientist = new Scientist();
//                    Attribute id = element.getAttributeByName(new QName("id"));
//                    Attribute name = element.getAttributeByName(new QName("name"));
//                    Attribute lastName = element.getAttributeByName(new QName("lastname"));
//                    Attribute nationality = element.getAttributeByName(new QName("nationality"));
//                    Attribute age = element.getAttributeByName(new QName("age"));
//                    scientist.setId(Integer.parseInt(id.getValue()));
//                    scientist.setName(name.getValue());
//                    scientist.setLastName(lastName.getValue());
//                    scientist.setNationality(nationality.getValue());
//                    scientist.setAge(Integer.parseInt(age.getValue()));
//                    research.setScientist(scientist);
//                    LOGGER.info(research);
//                } else {
//                    LOGGER.warn("\nElement isn't a Research");
//                }
//            }
//        }
//    }
//
//    public static void printAllAssistants(XMLEventReader r) throws XMLStreamException {
//        Assistant assistant = new Assistant();
//        while (r.hasNext()) {
//            XMLEvent e = r.nextEvent();
//            if (e.isStartElement()) {
//                StartElement element = e.asStartElement();
//                if (e.asStartElement().getName().toString().equals("assistant")) {
//                    Attribute id = element.getAttributeByName(new QName("id"));
//                    Attribute name = element.getAttributeByName(new QName("name"));
//                    Attribute lastName = element.getAttributeByName(new QName("lastname"));
//                    Attribute nationality = element.getAttributeByName(new QName("nationality"));
//                    Attribute age = element.getAttributeByName(new QName("age"));
//                    assistant.setId(Integer.parseInt(id.getValue()));
//                    assistant.setName(name.getValue());
//                    assistant.setLastName(lastName.getValue());
//                    assistant.setNationality(nationality.getValue());
//                    assistant.setAge(Integer.parseInt(age.getValue()));
//                } else if (e.asStartElement().getName().toString().equals("scientist")) {
//                    Scientist scientist = new Scientist();
//                    Attribute id = element.getAttributeByName(new QName("id"));
//                    Attribute name = element.getAttributeByName(new QName("name"));
//                    Attribute lastName = element.getAttributeByName(new QName("lastname"));
//                    Attribute nationality = element.getAttributeByName(new QName("nationality"));
//                    Attribute age = element.getAttributeByName(new QName("age"));
//                    scientist.setId(Integer.parseInt(id.getValue()));
//                    scientist.setName(name.getValue());
//                    scientist.setLastName(lastName.getValue());
//                    scientist.setNationality(nationality.getValue());
//                    scientist.setAge(Integer.parseInt(age.getValue()));
//                    assistant.setScientist(scientist);
//                    LOGGER.info(assistant);
//                } else {
//                    LOGGER.warn("\nElement isn't a Assistant");
//                }
//            }
//        }
//    }


}
