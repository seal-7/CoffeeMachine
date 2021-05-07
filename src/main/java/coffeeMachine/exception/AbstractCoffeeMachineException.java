package coffeeMachine.exception;

import lombok.Getter;

/**
 * Parent Exception class for capturing all Coffee Machine exceptions.
 */
@Getter
public abstract class AbstractCoffeeMachineException extends Exception {
    protected String machineOutput;
}
