package per.sl.appsys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {
    private Logger log = Logger.getLogger(StringToDateConverter.class);
    private String datePattern;

    public StringToDateConverter(String datePattern) {
        log.info("StringToDateConver convert:" + datePattern);
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            date = new SimpleDateFormat(datePattern).parse(source.toString());
            log.debug("StringToDateConver convert date:" + date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
