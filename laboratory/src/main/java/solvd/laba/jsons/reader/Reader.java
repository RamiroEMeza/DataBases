package solvd.laba.jsons.reader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.entities.research.Research;

import java.io.File;
import java.io.IOException;

public class Reader {
    private final static Logger LOGGER = LogManager.getLogger(Reader.class);

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Research research = mapper.readValue(new File("./src/main/resources/jsons/research.json"), Research.class);
        LOGGER.info(research);
    }
}
