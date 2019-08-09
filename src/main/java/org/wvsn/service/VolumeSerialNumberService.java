package org.wvsn.service;

import org.springframework.stereotype.Service;
import org.wvsn.beans.DateVSN;
import org.wvsn.engine.VolumeSerialNumber;
import org.wvsn.utils.RandomDateTimeGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class VolumeSerialNumberService {

    public DateVSN fromDate(String date) {
        VolumeSerialNumber vsn = new VolumeSerialNumber();

        LocalDateTime parsedDate = LocalDateTime.parse(date, PARSER);

        DateVSN dateVSN = new DateVSN();

        dateVSN.setDateTime(parsedDate);
        dateVSN.setSerialNumber(vsn.calculate(parsedDate));

        return dateVSN;
    }

    public DateVSN randomDate() {
        VolumeSerialNumber vsn = new VolumeSerialNumber();
        RandomDateTimeGenerator rdtg = new RandomDateTimeGenerator();

        DateVSN dateVSN = new DateVSN();

        dateVSN.setDateTime(rdtg.generateDateTime());
        dateVSN.setSerialNumber(vsn.calculate(dateVSN.getDateTime()));

        return dateVSN;
    }

    private static final DateTimeFormatter PARSER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n");
}
