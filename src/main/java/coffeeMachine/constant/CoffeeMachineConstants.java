package coffeeMachine.constant;

/**
 * Strings constants related to CoffeeMachine.
 */
public class CoffeeMachineConstants {
    /* Success message returned when the beverage was successfully served. */
    public static final String BEVERAGE_PREPARATION_SUCCESS_MESSAGE = "%s is prepared";
    /* Message indicating insufficient ingredients for making the beverage.  */
    public static final String BEVERAGE_PREPARATION_INSUFFICIENT_FAILURE_MESSAGE = "%s cannot be prepared because %s is not sufficient";
    /* Message indicating ingredients not available for making the beverage.  */
    public static final String BEVERAGE_PREPARATION_NOT_AVAILABLE_FAILURE_MESSAGE = "%s cannot be prepared because %s is not available";
    /* Message indicating invalid beverage name which is not supported by coffee machine. */
    public static final String NO_SUCH_BEVERAGE_FAILURE_MESSAGE = "Cannot serve %s beverage. Please select a valid beverage";
    /* Number of outlets of the coffee machine. */
    public static final String NUMBER_OF_OUTLETS_KEY = "count_n";

    /* Test Input. Note: Remove the extra comma at the end of JSON as ObjectMapper does not support it.
    * Not supported Eg: {
    * "x": 1,
    * "y": 2, <-
    * }
    * */
    public static final String TEST_INPUT_1 = "{\n" +
            "  \"machine\": {\n" +
            "    \"outlets\": {\n" +
            "      \"count_n\": 3\n" +
            "    },\n" +
            "    \"total_items_quantity\": {\n" +
            "      \"hot_water\": 500,\n" +
            "      \"hot_milk\": 500,\n" +
            "      \"ginger_syrup\": 100,\n" +
            "      \"sugar_syrup\": 100,\n" +
            "      \"tea_leaves_syrup\": 100\n" +
            "    },\n" +
            "    \"beverages\": {\n" +
            "      \"hot_tea\": {\n" +
            "        \"hot_water\": 200,\n" +
            "        \"hot_milk\": 100,\n" +
            "        \"ginger_syrup\": 10,\n" +
            "        \"sugar_syrup\": 10,\n" +
            "        \"tea_leaves_syrup\": 30\n" +
            "      },\n" +
            "      \"hot_coffee\": {\n" +
            "        \"hot_water\": 100,\n" +
            "        \"ginger_syrup\": 30,\n" +
            "        \"hot_milk\": 400,\n" +
            "        \"sugar_syrup\": 50,\n" +
            "        \"tea_leaves_syrup\": 30\n" +
            "      },\n" +
            "      \"black_tea\": {\n" +
            "        \"hot_water\": 300,\n" +
            "        \"ginger_syrup\": 30,\n" +
            "        \"sugar_syrup\": 50,\n" +
            "        \"tea_leaves_syrup\": 30\n" +
            "      },\n" +
            "      \"green_tea\": {\n" +
            "        \"hot_water\": 100,\n" +
            "        \"ginger_syrup\": 30,\n" +
            "        \"sugar_syrup\": 50,\n" +
            "        \"green_mixture\": 30\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
