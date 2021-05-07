package coffeeMachine.service;

import coffeeMachine.config.BeverageConfig;
import coffeeMachine.dao.Inventory;
import coffeeMachine.exception.AbstractCoffeeMachineException;
import lombok.AllArgsConstructor;

import java.util.Map;

import static coffeeMachine.constant.CoffeeMachineConstants.BEVERAGE_PREPARATION_SUCCESS_MESSAGE;

/**
 * Service class handling logic for serving the specified beverage.
 */
@AllArgsConstructor
public class CoffeeMachineService {
    private final Inventory inventory;
    private final BeverageConfig beverageConfig;

    /**
     * Fetches required ingredients from BeverageConfiguration and
     * reduces those ingredients from the inventory.
     * @param beverage Name of the Beverage to be served.
     * @return String indicating if the beverage was served or not.
     */
    public String serve(String beverage) {
        try {
            Map<String, Integer> ingredients = beverageConfig.getIngredients(beverage);
            inventory.reduceIngredients(ingredients, beverage);
        } catch (final AbstractCoffeeMachineException exception) {
            return handleException(exception, beverage);
        }
        return String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, beverage);
    }

    String handleException(final AbstractCoffeeMachineException exception, final String beverage) {
        return exception.getMachineOutput();
    }

}
