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

    public abstract String solvePart1(String puzzleInput);
    public abstract String solvePart2(String puzzleInput);

    public List<Integer> getListOfIntegerFromInput(String puzzleInput) {
        String fileName = getFileName(puzzleInput);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Long> getListOfLongFromInput(String puzzleInput) {
        String fileName = getFileName(puzzleInput);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getListOfStringFromInput(String puzzleInput) {
        String fileName = getFileName(puzzleInput);
        List<String> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getStringFromInput(String puzzleInput) {
        String fileName = getFileName(puzzleInput);
        String getData = "";
        try {
            getData = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getData;
    }

    private String getFileName(String puzzleInput) {
        try {
            Integer.parseInt(puzzleInput);
            return INPUT.replace("00", (puzzleInput.length() == 1) ? "0" + puzzleInput : puzzleInput);
        } catch (NumberFormatException e) {
            return puzzleInput;
        }

    }

}
