package solvd.laba.extensibles.reader;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.parse(s);
    }

    @Override
    public String marshal(LocalDate date) {
        return new SimpleDateFormat("MM-dd-yyyy").format(date);
    }

}
