package data_structures.graph.medium;

import java.util.*;

public class EmployeeImportance_690 {

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int totalImportance = 0;
        while (!queue.isEmpty()) {
            int empId = queue.poll();
            Employee employee = employeeMap.get(empId);
            totalImportance += employee.importance;
            queue.addAll(employee.subordinates);
        }
        return totalImportance;
    }

    public static void main(String[] args) {
        EmployeeImportance_690 employeeImportance690 = new EmployeeImportance_690();
        Employee e1 = new Employee();
        e1.id =1;
        e1.importance=5;
        e1.subordinates=Arrays.asList(2,3);
        Employee e2 = new Employee();
        e2.id =2;
        e2.importance=3;
        e2.subordinates=Collections.emptyList();
        Employee e3 = new Employee();
        e3.id =3;
        e3.importance=3;
        e3.subordinates=Collections.emptyList();
        List<Employee> employees = Arrays.asList(e1, e2, e3);
        System.out.println(employeeImportance690.getImportance(employees, 1));
    }
}
