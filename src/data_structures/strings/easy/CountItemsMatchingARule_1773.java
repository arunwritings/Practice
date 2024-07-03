package data_structures.strings.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingARule_1773 {

    /**
     Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
     Output: 1
     Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"]
     **/
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> throw new IllegalArgumentException("Invalid ruleKey: " + ruleKey);
        };

        return (int) items.stream()
                .filter(item -> item.get(index).equals(ruleValue))
                .count();
    }

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));

        String ruleKey = "type";
        String ruleValue = "phone";

        int count = countMatches(items, ruleKey, ruleValue);
        System.out.println(count);
    }
}
