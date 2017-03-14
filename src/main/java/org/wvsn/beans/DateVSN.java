package org.wvsn.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateVSN {

    public DateVSN() {}

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.setFormattedDate(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        this.dateTime = dateTime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    @JsonIgnore
    private LocalDateTime dateTime;
    private String formattedDate;
    private String serialNumber;
}
