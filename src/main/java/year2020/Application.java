package year2020;

import year2020.days.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna S. Almielka
 * 07.12.2020
 */

public class Application {

    public static void main(String[] args) throws InstantiationException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {

        List<AbstractDay> days = new ArrayList<>();

        for (int i = 1; i <= 5; i++) { //i will be increased up to 25
            String day = (i < 10) ? "0" + i : String.valueOf(i);
            days.add((AbstractDay) Class.forName("year2020.days.day" + day + ".Day" + day).getConstructor().newInstance());
        }

        days.forEach(day -> {
            System.out.println("Day " + day.getDay() + ", Part 1: " + day.solvePart1());
            System.out.println("Day " + day.getDay() + ", Part 2: " + day.solvePart2());
        });

    }

}
