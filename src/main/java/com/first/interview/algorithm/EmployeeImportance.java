package com.first.interview.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id){
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return getImportanceSum(map, id);
    }

    private int getImportanceSum(Map<Integer, Employee> map, int id) {
        int rootImportance = map.get(id).importance;
        int subordinateImportance = map.get(id).subordinates
                .stream().mapToInt(i -> getImportanceSum(map, i))
                .sum();
        return rootImportance + subordinateImportance;
    }

    /*
    int getImportant(Map<Id, Employee> map, Integer myId) {
       return map.get(myId).importance + map.get(myId).subordinates.stream.map(i -> getImportance(map, i)).sum();
    }
     */

    private static class Employee{
        int id;
        int importance;
        List<Integer> subordinates;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = new ArrayList<Integer>(Arrays.asList(2,3));

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<Integer>();

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<Integer>();

        EmployeeImportance ep = new EmployeeImportance();

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        int res = ep.getImportance(list, 1);
        System.out.println(res);


    }
}
