package coffeeMachine.service;


import coffeeMachine.TestHelper;
import coffeeMachine.config.BeverageConfig;
import coffeeMachine.dao.Inventory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import static coffeeMachine.TestConstants.*;
import static org.junit.Assert.assertEquals;

public class CoffeeMachineServiceTest {

    @Test
    public void shouldServeBeverage_whenIngredientsAvailable() throws JsonProcessingException {
        //Assign
        Inventory inventory = Inventory.getInstance(TestHelper.getMockedInventory());
        BeverageConfig beverageConfig = new BeverageConfig(TestHelper.getMockedBeverageConfig());
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverageConfig);

        //Act
        String output = coffeeMachineService.serve(HOT_TEA_BEVERAGE);

        //Assert
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_TEA_BEVERAGE), output);
    }

    @Test
    public void shouldNotServeBeverage_whenIngredientsUnavailable() throws JsonProcessingException {
        //Assign
        Inventory inventory = Inventory.getInstance(TestHelper.getMockedInventory());
        BeverageConfig beverageConfig = new BeverageConfig(TestHelper.getMockedBeverageConfig());
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverageConfig);

        //Act
        String output = coffeeMachineService.serve(GREEN_TEA_BEVERAGE);

        //Assert
        assertEquals(String.format(BEVERAGE_PREPARATION_NOT_AVAILABLE_FAILURE_MESSAGE, GREEN_TEA_BEVERAGE, GREEN_MIXTURE_INGREDIENT), output);
    }

    @Test
    public void shouldServeMultipleBeverage_whenIngredientAvailable() throws JsonProcessingException {
        //Assign
        Inventory inventory = Inventory.getInstance(TestHelper.getMockedInventory());
        BeverageConfig beverageConfig = new BeverageConfig(TestHelper.getMockedBeverageConfig());
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverageConfig);

        //Act
        String output1 = coffeeMachineService.serve(HOT_TEA_BEVERAGE);
        String output2 = coffeeMachineService.serve(HOT_COFFEE_BEVERAGE);

        //Assert
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_TEA_BEVERAGE), output1);
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_COFFEE_BEVERAGE), output2);
    }

    @Test
    public void shouldNotServeBeverage_whenIngredientInsufficient() throws JsonProcessingException {
        //Assign
        Inventory inventory = Inventory.getInstance(TestHelper.getMockedInventory());
        BeverageConfig beverageConfig = new BeverageConfig(TestHelper.getMockedBeverageConfig());
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverageConfig);

        //Act
        String output1 = coffeeMachineService.serve(HOT_TEA_BEVERAGE);
        String output2 = coffeeMachineService.serve(HOT_COFFEE_BEVERAGE);
        String output3 = coffeeMachineService.serve(BLACK_TEA_BEVERAGE);

        //Assert
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_TEA_BEVERAGE), output1);
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_COFFEE_BEVERAGE), output2);
        assertEquals(String.format(BEVERAGE_PREPARATION_INSUFFICIENT_FAILURE_MESSAGE, BLACK_TEA_BEVERAGE, HOT_WATER_INGREDIENT), output3);
    }
}
