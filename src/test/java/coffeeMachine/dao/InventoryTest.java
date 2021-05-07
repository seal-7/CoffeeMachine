package coffeeMachine.dao;

import coffeeMachine.TestConstants;
import coffeeMachine.TestHelper;
import coffeeMachine.exception.IngredientUnavailableException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    @Test
    public void shouldReduceAvailableInventory_afterServingAvailableBeverage() throws JsonProcessingException, IngredientUnavailableException {
        //Assign
        final ConcurrentHashMap<String, Integer> mockAvailableIngredients = TestHelper.getMockedInventory();
        final Inventory inventory = Inventory.getInstance(mockAvailableIngredients);
        final Map<String, Integer> mockRequiredIngredients = TestHelper.getMockedIngredients(TestConstants.HOT_TEA_BEVERAGE);
        final ConcurrentHashMap<String, Integer> expectedReducedIngredients = TestHelper.getMockedInventory();

        //Act
        inventory.reduceIngredients(mockRequiredIngredients, TestConstants.HOT_TEA_BEVERAGE);
        reduceInventory(expectedReducedIngredients, mockRequiredIngredients);

        //Assert
        final ConcurrentHashMap<String, Integer> reducedIngredients = inventory.getAvailableIngredient();
        assertEquals(expectedReducedIngredients, reducedIngredients);
    }

    @Test(expected = IngredientUnavailableException.class)
    public void shouldThrowIngredientUnavailableException_whenIngredientUnavailable() throws IngredientUnavailableException, JsonProcessingException {
        //Assign
        final ConcurrentHashMap<String, Integer> mockAvailableIngredients = TestHelper.getMockedInventory();
        final Inventory inventory = Inventory.getInstance(mockAvailableIngredients);
        final Map<String, Integer> mockRequiredIngredients = TestHelper.getMockedIngredients(TestConstants.GREEN_TEA_BEVERAGE);

        //Act
        inventory.reduceIngredients(mockRequiredIngredients, TestConstants.GREEN_TEA_BEVERAGE);
    }

    private void reduceInventory(ConcurrentHashMap<String, Integer> mockAvailableIngredients, final Map<String, Integer> mockRequiredIngredients) {
        for(Map.Entry<String, Integer> ingredient : mockRequiredIngredients.entrySet()) {
            int availableQuantity =  mockAvailableIngredients.get(ingredient.getKey());
            mockAvailableIngredients.put(ingredient.getKey(), availableQuantity - ingredient.getValue());
        }
    }
}
