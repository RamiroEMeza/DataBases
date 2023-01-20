package solvd.laba;

import org.apache.commons.io.FileUtils;
import solvd.laba.equipment.Equipment;

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
    public static void main(String[] args) throws IOException, XMLStreamException {
        File lorem = new File("../laboratory/src/main/resources/eXtensibles/equipment/equipments.xml");
        System.out.println(lorem.getName() + " " + lorem.getAbsolutePath());

        XMLEventReader r = XMLInputFactory.newFactory()
                .createXMLEventReader(new FileInputStream(lorem.toString()));

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
                switch (e.asStartElement().getName().toString()) {
                    case "equipment":
                        Equipment equipment = new Equipment();
                        equipment.setId(Integer.parseInt(e.asStartElement().getAttributeByName(QName.valueOf("id")).getValue()));
                        equipment.setName(String.valueOf(e.asStartElement().getAttributeByName(QName.valueOf("name")).getValue()));

                        if (e.asStartElement().getAttributeByName(QName.valueOf("working")).getValue().equals("1")) {
                            equipment.setWorking(true);
                        }
                        System.out.println(equipment);
                        break;
                }
            }
        }

    }
}
