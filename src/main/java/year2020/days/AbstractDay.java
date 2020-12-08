package year2020.days;

import shared.Day;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public abstract class AbstractDay extends Day {
    private static final int YEAR = 2020;
    private static final String INPUT = "src/main/resources/year2020/day-00-input.txt";

    public AbstractDay(int day) {
        super(YEAR, day);
    }

    public abstract String solvePart1();

    public abstract String solvePart2();

    public abstract int getDay();

    public List<Integer> getDataInputOfInteger(int day) {
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

    public List<String> getDataInputOfString(int day) {
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

    private String getFileName(int day) {
        String dayString = String.valueOf(day);
        return INPUT.replace("00", (dayString.length() == 1) ? "0" + dayString : dayString);
    }

}