package solvd.laba.jsons.reader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;
import solvd.laba.entities.research.Research;
import solvd.laba.entities.test.subjects.Subject;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reader {
    private final static Logger LOGGER = LogManager.getLogger(Reader.class);

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());


        Research researchFromFile = mapper.readValue(new File("./src/main/resources/jsons/research.json"), Research.class);
        LOGGER.info(researchFromFile);

        LocalDate lD = LocalDate.of(2023, 1, 26);

        Research researchFromJava = new Research("Atomic fusion"
                , LocalDate.of(2023, 1, 26)
                , 9000
                , false);
        Scientist scientistFromJava = new Scientist("CreatedIn", "Java", "mexican", 44, 9);
        ArrayList<Assistant> assistants = new ArrayList<Assistant>();
        assistants.add(new Assistant("George", "Wales", "british", 23));
        scientistFromJava.setAssistants(assistants);
        researchFromJava.setScientist(scientistFromJava);
        researchFromJava.addTestSubjects(new Subject("donkey", 4, false, 200));
        researchFromJava.setLab(new Lab(9, 6, 3));

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./src/main/resources/jsons/researchFromJava.json"), researchFromJava);
    }
}
