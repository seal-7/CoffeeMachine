package coffeeMachine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestHelper {

    public static ConcurrentHashMap<String, Integer> getMockedInventory() {
        ConcurrentHashMap<String, Integer> availableIngredientQuantity = new ConcurrentHashMap<>();
        availableIngredientQuantity.put("hot_water", 500);
        availableIngredientQuantity.put("hot_milk", 500);
        availableIngredientQuantity.put("ginger_syrup", 100);
        availableIngredientQuantity.put("sugar_syrup", 100);
        availableIngredientQuantity.put("tea_leaves_syrup", 100);
        return availableIngredientQuantity;
    }

    public static Map<String, Map<String, Integer>> getMockedBeverageConfig() throws JsonProcessingException {
        String beveragesJson = "{\n" +
                "      \"hot_tea\": {\n" +
                "        \"hot_water\": 200,\n" +
                "        \"hot_milk\": 100,\n" +
                "        \"ginger_syrup\": 10,\n" +
                "        \"sugar_syrup\": 10,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"hot_coffee\": {\n" +
                "        \"hot_water\": 100,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"hot_milk\": 400,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"black_tea\": {\n" +
                "        \"hot_water\": 300,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"green_tea\": {\n" +
                "        \"hot_water\": 100,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"green_mixture\": 30\n" +
                "      }\n" +
                "    }";

        return new ObjectMapper().readValue(beveragesJson, Map.class);
    }

    public static Map<String, Integer> getMockedIngredients(String mockedBeverage) throws JsonProcessingException {
        Map<String, Map<String, Integer>> beverages =  getMockedBeverageConfig();
        return beverages.get(mockedBeverage);
    }
}
