package coffeeMachine.exception;

import lombok.Getter;

/**
 * thrown when the required ingredients are not configured for the given beverage.
 */
@Getter
public class NoSuchBeverageException extends AbstractCoffeeMachineException {

    public NoSuchBeverageException(String machineOutput) {
        this.machineOutput = machineOutput;
    }
}
