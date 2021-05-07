package coffeeMachine;

import coffeeMachine.config.BeverageConfig;
import coffeeMachine.dao.Inventory;
import coffeeMachine.dto.CoffeeMachineInputDto;
import coffeeMachine.dto.InputDto;
import coffeeMachine.service.CoffeeMachineService;
import coffeeMachine.service.CoffeeWorkerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static coffeeMachine.constant.CoffeeMachineConstants.NUMBER_OF_OUTLETS_KEY;
import static coffeeMachine.constant.CoffeeMachineConstants.TEST_INPUT_1;

/**
 * Entry point or Main class for executing the Coffee machine.
 * Creates inventory, configures ingredients required for given beverage
 * and serves beverage from the provided number of outlets.
 */
public class CoffeeMachine {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        final CoffeeMachineInputDto coffeeMachineInputDto = getParsedInput();
        final Inventory inventory = Inventory.getInstance(coffeeMachineInputDto.getTotalItemsQuantity());
        final BeverageConfig beverageConfig = new BeverageConfig(coffeeMachineInputDto.getBeverages());
        final List<String> beverages = beverageConfig.getBeverages();
        final int outlets = coffeeMachineInputDto.getOutlets().get(NUMBER_OF_OUTLETS_KEY);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(outlets);

        for(int i=0; i<beverages.size(); i++) {
            CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverageConfig);
            Runnable coffeeMachineWorker =
                    new CoffeeWorkerService(coffeeMachineService, beverages.get(i));
            executor.execute(coffeeMachineWorker);
        }
        executor.shutdown();
    }

    public static CoffeeMachineInputDto getParsedInput() throws JsonProcessingException {
        String jsonInput = TEST_INPUT_1;
        InputDto inputDto = objectMapper.readValue(jsonInput, InputDto.class);
        return inputDto.getMachine();
    }
}
