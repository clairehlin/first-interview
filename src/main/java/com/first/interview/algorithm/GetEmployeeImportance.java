package com.first.interview.algorithm;

import java.util.List;

public class GetEmployeeImportance {
    int getImportance(List<Employee> employees, int id) {
        Employee manager = getEmployee(employees, id);
        int totalImportance = manager.importance;


        if (manager.subordinates != null) {
            for (Integer subordinateId : manager.subordinates) {
                totalImportance = totalImportance + getImportance(employees, subordinateId);
            }
//            for (int j = 0; j < employees.get(i).subordinates.size(); j++) {
//                int subordinateId = employees.get(i).subordinates.get(j);
//                Employee subordinate = getEmployee(employees, subordinateId);
//                sumSubValues = sumSubValues + subordinate.importance;
//            }
        }
        return totalImportance;
    }

    private Employee getEmployee(List<Employee> employees, int subordinateId) {
        Employee employee = new Employee();
        for (Employee emp : employees) {
            if (emp.id == subordinateId) {
                employee = emp;
                break;
            }
        }
        return employee;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public static void main(String[] args) {

    }
}
