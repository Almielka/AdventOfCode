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

    public AbstractDay(int day) {
        super(YEAR, day);
    }

    public abstract void solvePart1();

    public abstract void solvePart2();

    public abstract int getDay();

    public List<Integer> getDataInputOfInteger(String fileName) {
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

    public List<String> getDataInputOfString(String fileName) {
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

}