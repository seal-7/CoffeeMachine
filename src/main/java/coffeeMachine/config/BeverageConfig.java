package coffeeMachine.config;

import coffeeMachine.exception.NoSuchBeverageException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static coffeeMachine.constant.CoffeeMachineConstants.NO_SUCH_BEVERAGE_FAILURE_MESSAGE;

/**
 * Configuration class holding all the required beverages for a particular beverage.
 */
public class BeverageConfig {
    Map<String, Map<String, Integer>> beverageIngredients;

    public BeverageConfig(Map<String, Map<String, Integer>> beverageIngredients) {
        this.beverageIngredients = beverageIngredients;
    }

    /**
     * @param beverage name of the beverage for which the ingredients has to be fetched.
     * @return ingredients for making request beverage.
     * @throws NoSuchBeverageException if the required ingredients are not configured for the given beverage.
     */
    public Map<String, Integer> getIngredients(String beverage) throws NoSuchBeverageException {
        Map<String, Integer> ingredients = beverageIngredients.get(beverage);
        if(ingredients == null) {
            throw new NoSuchBeverageException(String.format(NO_SUCH_BEVERAGE_FAILURE_MESSAGE, beverage));
        }
        return ingredients;
    }

    /**
     * @return List of all the configured beverages.
     */
    public List<String> getBeverages() {
        return beverageIngredients.keySet().stream().collect(Collectors.toList());
    }
}
