package data_structures.arrays.easy;

public class NumberOfEmployeesWhoMetTheTarget_2798 {

    /**
     Input: hours = [5,1,4,2,2], target = 6
     Output: 0
     Explanation: The company wants each employee to work for at least 6 hours.
     There are 0 employees who met the target.
     **/
    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int result = numberOfEmployeesWhoMetTarget(new int[]{5,1,4,2,2}, 6);
        System.out.println(result);
    }
}
