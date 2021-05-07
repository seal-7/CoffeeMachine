package coffeeMachine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class for parsing json input to POJO.
 */
@NoArgsConstructor
@Getter
public class CoffeeMachineInputDto {
    Map<String, Integer> outlets;
    @JsonProperty(value = "total_items_quantity")
    ConcurrentHashMap<String, Integer> totalItemsQuantity;
    Map<String, Map<String, Integer>> beverages;
}
