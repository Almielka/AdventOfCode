package shared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public abstract class AbstractDay {

    protected int year;
    protected int day;
    private static final String DELIMITER = File.separator;
    protected String INPUT;

    public AbstractDay(int year, int day) {
        this.year = year;
        this.day = day;
        INPUT = "src" + DELIMITER + "main" + DELIMITER + "resources" +
                DELIMITER + "year" + year + DELIMITER + "day-00-input.txt";
    }

    public int getDay() {
        return day;
    }

    public abstract String solvePart1();
    public abstract String solvePart2();

    public List<Integer> getListOfIntegerFromInput(int day) {
        String fileName = getFileName(day);
        List<Integer> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                try {
                    Integer number = Integer.parseInt(line);
                    list.add(number);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Long> getListOfLongFromInput(int day) {
        String fileName = getFileName(day);
        List<Long> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                try {
                    Long number = Long.parseLong(line);
                    list.add(number);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getListOfStringFromInput(int day) {
        String fileName = getFileName(day);
        List<String> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                list.add(line);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getStringFromInput(int day) {
        String fileName = getFileName(day);
        String getData = "";
        try {
            getData = Files.readString(Paths.get(fileName));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return getData;
    }

    private String getFileName(int day) {
        String dayString = String.valueOf(day);
        return INPUT.replace("00", (dayString.length() == 1) ? "0" + dayString : dayString);
    }

}

