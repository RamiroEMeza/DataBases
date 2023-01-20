package solvd.laba;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.mysql.EquipmentDAO;
import solvd.laba.equipment.Equipment;
import solvd.laba.facilities.Lab;
import solvd.laba.members.Assistant;
import solvd.laba.members.Scientist;
import solvd.laba.research.Research;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    private final static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader r = xmlInputFactory.createXMLEventReader(
                new FileInputStream("../laboratory/src/main/resources/eXtensibles/equipment/equipments.xml"));

        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                StartElement element = e.asStartElement();
                if (element.getName().getLocalPart().equals("equipment")) {
                    Equipment equipment = new Equipment();
                    Attribute id = element.getAttributeByName(new QName("id"));
                    Attribute name = element.getAttributeByName(new QName("name"));
                    Attribute working = element.getAttributeByName(new QName("working"));
                    equipment.setId(Integer.parseInt(id.getValue()));
                    equipment.setName(name.getValue());
                    if (working.getValue().equals("1")) {
                        equipment.setWorking(true);
                    }
                    LOGGER.info(equipment);
                } else {
                    LOGGER.warn("Element isn't an Equipment");
                }
            }
        }
        r = xmlInputFactory.createXMLEventReader(
                new FileInputStream("../laboratory/src/main/resources/eXtensibles/scientist/scientists.xml"));

        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                StartElement element = e.asStartElement();
                if (element.getName().getLocalPart().equals("scientist")) {
                    Scientist scientist = new Scientist();
                    Attribute id = element.getAttributeByName(new QName("id"));
                    Attribute name = element.getAttributeByName(new QName("name"));
                    Attribute lastName = element.getAttributeByName(new QName("lastname"));
                    Attribute nationality = element.getAttributeByName(new QName("nationality"));
                    Attribute age = element.getAttributeByName(new QName("age"));
                    scientist.setId(Integer.parseInt(id.getValue()));
                    scientist.setName(name.getValue());
                    scientist.setLastName(lastName.getValue());
                    scientist.setNationality(nationality.getValue());
                    scientist.setAge(Integer.parseInt(age.getValue()));
                    LOGGER.info(scientist);
                } else {
                    LOGGER.warn("Element isn't a Scientist");
                }
            }
        }

        r = xmlInputFactory.createXMLEventReader(
                new FileInputStream("../laboratory/src/main/resources/eXtensibles/lab/labs.xml"));


        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                StartElement element = e.asStartElement();
                if (e.asStartElement().getName().toString().equals("lab")) {
                    Lab lab = new Lab();
                    Attribute id = element.getAttributeByName(new QName("id"));
                    Attribute capacity = element.getAttributeByName(new QName("capacity"));
                    Attribute complexity = element.getAttributeByName(new QName("complexity"));
                    lab.setId(Integer.parseInt(id.getValue()));
                    lab.setCapacity(Integer.parseInt(capacity.getValue()));
                    lab.setComplexity(Integer.parseInt(complexity.getValue()));
                    LOGGER.info(lab);
                } else {
                    LOGGER.warn("Element isn't a Lab");
                }
            }
        }

        r = xmlInputFactory.createXMLEventReader(
                new FileInputStream("../laboratory/src/main/resources/eXtensibles/research/researches.xml"));

        Research research = new Research();
        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                StartElement element = e.asStartElement();
                if (e.asStartElement().getName().toString().equals("research")) {
                    Attribute id = element.getAttributeByName(new QName("id"));
                    Attribute name = element.getAttributeByName(new QName("name"));
                    Attribute budget = element.getAttributeByName(new QName("budget"));
                    Attribute complete = element.getAttributeByName(new QName("complete"));
                    research.setId(Integer.parseInt(id.getValue()));
                    research.setName(name.getValue());
                    research.setBudget(Integer.parseInt(budget.getValue()));
                    if (complete.getValue().equals("1")) {
                        research.setComplete(true);
                    }
                } else if (e.asStartElement().getName().toString().equals("lab")) {
                    Lab lab = new Lab();
                    Attribute id = element.getAttributeByName(new QName("id"));
                    Attribute capacity = element.getAttributeByName(new QName("capacity"));
                    Attribute complexity = element.getAttributeByName(new QName("complexity"));
                    lab.setId(Integer.parseInt(id.getValue()));
                    lab.setCapacity(Integer.parseInt(capacity.getValue()));
                    lab.setComplexity(Integer.parseInt(complexity.getValue()));
                    research.setLab(lab);
                } else if (e.asStartElement().getName().toString().equals("scientist")) {
                    Scientist scientist = new Scientist();
                    Attribute id = element.getAttributeByName(new QName("id"));
                    Attribute name = element.getAttributeByName(new QName("name"));
                    Attribute lastName = element.getAttributeByName(new QName("lastname"));
                    Attribute nationality = element.getAttributeByName(new QName("nationality"));
                    Attribute age = element.getAttributeByName(new QName("age"));
                    scientist.setId(Integer.parseInt(id.getValue()));
                    scientist.setName(name.getValue());
                    scientist.setLastName(lastName.getValue());
                    scientist.setNationality(nationality.getValue());
                    scientist.setAge(Integer.parseInt(age.getValue()));
                    research.setScientist(scientist);
                    LOGGER.info(research);
                } else {
                    LOGGER.warn("Element isn't a Research");
                }
            }
        }

        r = xmlInputFactory.createXMLEventReader(
                new FileInputStream("../laboratory/src/main/resources/eXtensibles/assistant/assistants.xml"));

        Assistant assistant = new Assistant();
        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                StartElement element = e.asStartElement();
                if (e.asStartElement().getName().toString().equals("assistant")) {
                    Attribute id = element.getAttributeByName(new QName("id"));
                    Attribute name = element.getAttributeByName(new QName("name"));
                    Attribute lastName = element.getAttributeByName(new QName("lastname"));
                    Attribute nationality = element.getAttributeByName(new QName("nationality"));
                    Attribute age = element.getAttributeByName(new QName("age"));
                    assistant.setId(Integer.parseInt(id.getValue()));
                    assistant.setName(name.getValue());
                    assistant.setLastName(lastName.getValue());
                    assistant.setNationality(nationality.getValue());
                    assistant.setAge(Integer.parseInt(age.getValue()));
                } else if (e.asStartElement().getName().toString().equals("scientist")) {
                    Scientist scientist = new Scientist();
                    Attribute id = element.getAttributeByName(new QName("id"));
                    Attribute name = element.getAttributeByName(new QName("name"));
                    Attribute lastName = element.getAttributeByName(new QName("lastname"));
                    Attribute nationality = element.getAttributeByName(new QName("nationality"));
                    Attribute age = element.getAttributeByName(new QName("age"));
                    scientist.setId(Integer.parseInt(id.getValue()));
                    scientist.setName(name.getValue());
                    scientist.setLastName(lastName.getValue());
                    scientist.setNationality(nationality.getValue());
                    scientist.setAge(Integer.parseInt(age.getValue()));
                    assistant.setScientist(scientist);
                    LOGGER.info(assistant);
                } else {
                    LOGGER.warn("Element isn't a Assistant");
                }
            }
        }
    }
}
