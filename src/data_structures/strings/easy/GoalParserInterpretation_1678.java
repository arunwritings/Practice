package data_structures.strings.easy;

public class GoalParserInterpretation_1678 {

    /**
     Input: command = "G()(al)"
     Output: "Goal"
     Explanation: The Goal Parser interprets the command as follows:
     G -> G
     () -> o
     (al) -> al
     The final concatenated result is "Goal".
     **/
    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        for (int i=0;i<command.length();i++){
            if (command.charAt(i) == 'G') {
                result.append(command.charAt(i));
            } else if (command.charAt(i) == '(' && command.charAt(i+1) == ')') {
                result.append('o');
            } else if (command.charAt(i) == '(' && command.charAt(i+1) == 'a'&& command.charAt(i+2) == 'l'&& command.charAt(i+3) == ')') {
                result.append("al");
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String result = interpret("G()(al)");
        System.out.println(result);
    }
}
