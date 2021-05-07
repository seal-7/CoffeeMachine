package coffeeMachine.dao;


import coffeeMachine.exception.IngredientUnavailableException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static coffeeMachine.constant.CoffeeMachineConstants.BEVERAGE_PREPARATION_INSUFFICIENT_FAILURE_MESSAGE;
import static coffeeMachine.constant.CoffeeMachineConstants.BEVERAGE_PREPARATION_NOT_AVAILABLE_FAILURE_MESSAGE;

/**
 * Singleton Inventory class managing ingredient in the inventory.
 */
public class Inventory {

    private static Inventory instance = null;
    private static ConcurrentHashMap<String, Integer> availableIngredient = new ConcurrentHashMap<>();

    private Inventory() {

    }

    private Inventory(ConcurrentHashMap<String, Integer> totalAvailableQuantity) {
        availableIngredient = totalAvailableQuantity;
    }

    public static synchronized Inventory getInstance(ConcurrentHashMap<String, Integer> totalAvailableQuantity) {
        if (instance == null) {
            return new Inventory(totalAvailableQuantity);
        }
        return instance;
    }

    /**
     * Reduces the required ingredients from the inventory.
     * @param ingredients The required ingredients for making the beverage.
     * @param beverage The name of beverage that has to be prepared.
     * @throws IngredientUnavailableException thrown if any required ingredient is not available or insufficient.
     */
    public void reduceIngredients(Map<String, Integer> ingredients, String beverage)
            throws IngredientUnavailableException {
        for(Map.Entry<String, Integer> ingredientSet : ingredients.entrySet()) {
            String requiredIngredient = ingredientSet.getKey();
            Integer requiredQuantity = ingredientSet.getValue();
            Integer availableQuantity = availableIngredient.get(requiredIngredient);
            if (availableQuantity == null) {
                throw new IngredientUnavailableException(String.format(BEVERAGE_PREPARATION_NOT_AVAILABLE_FAILURE_MESSAGE,
                        beverage, requiredIngredient));
            }
            if (availableQuantity < requiredQuantity) {
                throw new IngredientUnavailableException(String.format(BEVERAGE_PREPARATION_INSUFFICIENT_FAILURE_MESSAGE,
                        beverage, requiredIngredient));
            }
            availableIngredient.put(requiredIngredient, availableQuantity - requiredQuantity);
        }
    }

    public static ConcurrentHashMap<String, Integer> getAvailableIngredient() {
        return availableIngredient;
    }
}
