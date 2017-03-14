package org.wvsn.engine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class VolumeSerialNumber {
    public String calculate(LocalDateTime timestamp) {
        String primeiroGrupo = "";
        String segundoGrupo = "";

        // Primeiro grupo
        String fator1 = String.format(HEXA_GROUP_FORMAT,
                addTrailingZeroes(convertToHex(timestamp.getMonthValue())),
                addTrailingZeroes(convertToHex(timestamp.getDayOfMonth())));
        String fator2 = String.format(HEXA_GROUP_FORMAT,
                addTrailingZeroes(convertToHex(timestamp.getSecond())),
                addTrailingZeroes(convertToHex(timestamp.getNano() / ONE_MILLION)));

        primeiroGrupo = String.format(FOUR_SPACES, addHexes(fator1, fator2)).replace(" ", "0");

        // Segundo grupo
        String fator3 = String.format(HEXA_GROUP_FORMAT,
                convertToHex(timestamp.getHour()),
                addTrailingZeroes(convertToHex(timestamp.getMinute())));
        String fator4 = convertToHex(timestamp.getYear());

        segundoGrupo = String.format(FOUR_SPACES, addHexes(fator3, fator4)).replace(" ", "0");

        String result = String.format(VLS_FORMAT, primeiroGrupo, segundoGrupo);

        return String.format(VLS_FORMAT, primeiroGrupo, segundoGrupo);
    }

    private String convertToHex(int number) {
        return Integer.toHexString(number);
    }

    private String addTrailingZeroes(String number) {
        return number.format(HEXA_NUMBER_FORMAT, number).replace(" ", "0");
    }

    private String addHexes(String hex1, String hex2) {
        return Integer.toHexString(
                Integer.parseInt(hex1, 16) + Integer.parseInt(hex2, 16)
        );
    }

    private static final String VLS_FORMAT = "%s-%s";
    private static final String HEXA_NUMBER_FORMAT = "%2s";
    private static final String HEXA_GROUP_FORMAT = "%s%s";
    private static final String FOUR_SPACES = "%4s";
    private static final int ONE_MILLION = 1_000_000;
}
