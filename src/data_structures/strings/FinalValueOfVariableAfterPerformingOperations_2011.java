package data_structures.strings;

public class FinalValueOfVariableAfterPerformingOperations_2011 {

    public static int finalValueAfterOperations(String[] operations) {
        int count = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                count++;
            } else {
                count--;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int result = finalValueAfterOperations(new String[]{"++X", "X--", "X--", "X++"});
        System.out.println("The final count of variable after performing operations is " + result);
    }
}
