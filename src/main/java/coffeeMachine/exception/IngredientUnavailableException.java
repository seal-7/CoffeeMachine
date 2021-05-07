package coffeeMachine.exception;

import lombok.Getter;

/**
 * Thrown when the required ingredient is either unavailable or not insufficient.
 */
@Getter
public class IngredientUnavailableException extends AbstractCoffeeMachineException {

    public IngredientUnavailableException(String machineOutput) {
        this.machineOutput = machineOutput;
    }
}
