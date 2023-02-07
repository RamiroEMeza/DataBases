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

        //Read json:
        Research researchFromFile = mapper
                .readValue(new File("laboratory/src/main/resources/jsons/research.json"), Research.class);
        LOGGER.info(researchFromFile);

        //Write json:
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("laboratory/src/main/resources/jsons/researchFileCopy.json"), researchFromFile);
    }
}
