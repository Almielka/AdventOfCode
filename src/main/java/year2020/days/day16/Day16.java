package year2020.days.day16;

import year2020.days.AbstractDay2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 31.12.2020
 */

public class Day16 extends AbstractDay2020 {
	
	  private static final int DAY = 16;

    public Day16() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        return String.valueOf(sumWrongValue(parseString(getStringFromInput(puzzleInput))));
    }

    @Override
    public String solvePart2(String puzzleInput) {
        return String.valueOf(getDepartureFieldsThenMultiply(parseString(getStringFromInput(puzzleInput))));
    }

    private Puzzle parseString(String str) {
        String[] allParts = str.split("\r\n\r\nnearby tickets:\r\n");
        String[] rulesAndMyTicketPart = allParts[0].split("\r\n\r\nyour ticket:\r\n");
        List<List<Integer>> tickets = Arrays.stream(allParts[1].split("\r\n")).map(this::parseTicket).collect(Collectors.toList());
        List<Rule> rules = Arrays.stream(rulesAndMyTicketPart[0].split("\r\n")).map(Rule::new).collect(Collectors.toList());
        return new Puzzle(parseTicket(rulesAndMyTicketPart[1]), tickets, rules);
    }

    private List<Integer> parseTicket(String str) {
        String[] arr = str.split(",");
        return Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int sumWrongValue(Puzzle puzzle) {
        return puzzle.tickets.stream()
                .flatMap(Collection::stream)
                .mapToInt(i -> i)
                .filter(v -> puzzle.rules.stream().noneMatch(rule -> rule.isValid(v)))
                .sum();
    }

    private long getDepartureFieldsThenMultiply(Puzzle puzzle) {
        long result = 1;
        Map<String, Integer> fields = getFields(puzzle);
        for (Map.Entry<String, Integer> pair : fields.entrySet()) {
            if (pair.getKey().startsWith("departure"))
                result *= pair.getValue();
        }
        return result;
    }

    private Map<String, Integer> getFields(Puzzle puzzle) {
        List<List<Integer>> validTickets = deleteWrongTickets(puzzle);
        int sizeTicket = puzzle.myTicket.size();
        Map<String, Integer> fields = new LinkedHashMap<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < sizeTicket; i++) {
            indexes.add(i);
        }
        while (fields.size() != sizeTicket) {
            ListIterator<Integer> listIterator = indexes.listIterator();
            while (listIterator.hasNext()) {
                int currentIndex = listIterator.next();
                List<String> names = puzzle.rules.stream().map(rule -> rule.name).collect(Collectors.toList());
                names.removeAll(fields.keySet());
                for (List<Integer> t : validTickets) {
                    List<String> wrongName = getWrongNameRule(t.get(currentIndex), puzzle.rules);
                    names.removeAll(wrongName);
                    if (names.size() == 1) {
                        fields.put(names.get(0), puzzle.myTicket.get(currentIndex));
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
        return fields;
    }

    private List<List<Integer>> deleteWrongTickets(Puzzle puzzle) {
        List<List<Integer>> validTickets = new ArrayList<>();
        puzzle.tickets.stream()
                .filter(t -> t.stream().allMatch(
                        v -> puzzle.rules.stream().anyMatch(rule -> rule.isValid(v))))
                .forEach(validTickets::add);
        return validTickets;
    }

    private List<String> getWrongNameRule(Integer value, List<Rule> rules) {
        List<String> names = new ArrayList<>();
        for (Rule r : rules) {
            if (!r.isValid(value))
                names.add(r.name);
        }
        return names;
    }

    private static class Rule {

        private String name;
        private int[] range;

        public Rule(String str) {
            String[] arr = str.split(":\s");
            name = arr[0];
            Matcher m = Pattern.compile("^(\\d+)-(\\d+)\\sor\\s(\\d+)-(\\d+)$").matcher(arr[1]);
            while (m.find()) {
                range = new int[]{
                        Integer.parseInt(m.group(1)),
                        Integer.parseInt(m.group(2)),
                        Integer.parseInt(m.group(3)),
                        Integer.parseInt(m.group(4))};
            }
        }

        private boolean isValid(int value) {
            return value >= range[0] && value <= range[1]
                    || value >= range[2] && value <= range[3];
        }

    }

    private class Puzzle {

        private List<Integer> myTicket;
        private List<List<Integer>> tickets;
        private List<Rule> rules;

        public Puzzle(List<Integer> myTicket, List<List<Integer>> tickets, List<Rule> rules) {
            this.myTicket = myTicket;
            this.tickets = tickets;
            this.rules = rules;
        }

    }

}
