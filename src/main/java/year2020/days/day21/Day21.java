package year2020.days.day21;

import year2020.days.AbstractDay2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Anna S. Almielka
 * 22.01.2021
 */

public class Day21 extends AbstractDay2020 {

    private static final int DAY = 21;
    private Set<String> checkedIngredients;

    public Day21() {
        super(DAY);
    }

    @Override
    public String solvePart1(String puzzleInput) {
        List<Food> foods = parseString(getStringFromInput(puzzleInput));
        checkedIngredients = new HashSet<>();
        Map<String, String> map = createMap(foods);
        return String.valueOf(countHealthyIngredients(foods, map));
    }

    @Override
    public String solvePart2(String puzzleInput) {
        List<Food> foods = parseString(getStringFromInput(puzzleInput));
        checkedIngredients = new HashSet<>();
        Map<String, String> map = createMap(foods);
        return getAllergensIngredients(map);
    }

    private List<Food> parseString(String str) {
        String[] arr = str.split("\r\n");
        return Arrays.stream(arr).map(Food::new).collect(Collectors.toList());
    }

    private int countHealthyIngredients(List<Food> foods, Map<String, String> map) {
        return (int) foods.stream()
                .flatMap(food -> food.ingredients.stream())
                .filter(i -> !map.containsValue(i))
                .count();
    }

    private String getAllergensIngredients(Map<String, String> map) {
        List<String> values = new ArrayList<>(map.values());
        return String.join(",", values);

    }

    private Map<String, String> createMap(List<Food> foods) {
        Map<String, String> map = new TreeMap<>();
        Set<String> allAllergens = foods.stream()
                .flatMap(food -> food.allergens.stream())
                .collect(Collectors.toSet());
        while (map.size() != allAllergens.size()) {
            for (Food food : foods) {
                for (String allergen : food.allergens) {
                    List<String> possiblyIngredients = new ArrayList<>(getPossiblyIngredients(foods, allergen));
                    if (possiblyIngredients.size() == 1) {
                        map.put(allergen, possiblyIngredients.get(0));
                        checkedIngredients.add(possiblyIngredients.get(0));
                    }
                }
            }
        }
        return map;
    }

    private Set<String> getPossiblyIngredients(List<Food> foods, String allergen) {
        List<Food> foodsCurrentAllergen = foods.stream()
                .filter(food -> food.allergens.contains(allergen))
                .collect(Collectors.toList());
        Set<String> ingredients = foodsCurrentAllergen.stream()
                .flatMap(food -> food.ingredients.stream())
                .filter(i -> !checkedIngredients.contains(i))
                .collect(Collectors.toSet());
        Set<String> possiblyIngredients = new HashSet<>();
        for (String ingredient : ingredients) {
            List<Food> possiblyFoods = foodsCurrentAllergen.stream()
                    .filter(food -> food.ingredients.contains(ingredient))
                    .collect(Collectors.toList());
            if (foodsCurrentAllergen.size() == possiblyFoods.size()) {
                possiblyIngredients.add(ingredient);
            }
        }
        return possiblyIngredients;
    }

    private static class Food {
        private List<String> ingredients;
        private List<String> allergens;

        public Food(String str) {
            Matcher m = Pattern.compile("(.+?)\\(contains\\s(.+?)\\)").matcher(str);
            while (m.find()) {
                String[] arrIngredients = m.group(1).split("\\s");
                ingredients = Arrays.asList(arrIngredients);
                String[] arrAllergens = m.group(2).split(",\\s");
                allergens = Arrays.asList(arrAllergens);
            }
        }

    }

}