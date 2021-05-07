package coffeeMachine.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class for parsing json input to POJO.
 */
@NoArgsConstructor
@Getter
public class InputDto {
  private CoffeeMachineInputDto machine;
}
