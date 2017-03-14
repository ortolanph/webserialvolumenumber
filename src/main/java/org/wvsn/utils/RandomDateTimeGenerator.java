package org.wvsn.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class RandomDateTimeGenerator {

    public LocalDateTime generateDateTime() {
        this.random = new Random();

        return LocalDateTime.of(
                generateDate(),
                generateTime()
        );
    }

    private LocalDate generateDate() {
        return LocalDate.of(
                random.nextInt(ALLOWED_YEAR),
                random.nextInt(LocalDate.MAX.getMonthValue()),
                random.nextInt(LocalDate.MAX.getDayOfMonth()));
    }

    private LocalTime generateTime() {
        return LocalTime.of(
                random.nextInt(LocalTime.MAX.getHour()),
                random.nextInt(LocalTime.MAX.getMinute()),
                random.nextInt(LocalTime.MAX.getSecond()),
                random.nextInt(ALLOWED_NANOS * ONE_MILLION)
        );
    }

    private Random random;
    private static final int ALLOWED_YEAR = 9999;
    private static final int ALLOWED_NANOS = 99;
    private static final int ONE_MILLION = 1_000_000;
}