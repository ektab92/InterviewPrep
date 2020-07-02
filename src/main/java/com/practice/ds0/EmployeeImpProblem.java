package com.practice.ds0;
import java.util.*;

public class EmployeeImpProblem {

    // Definition for Employee.
    public class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        Employee(int id, int importance)
        {
            this.id = id;
            this.importance = importance;
            subordinates = new ArrayList<>();
        }
    }
    int imp =0;
    Map<Integer,Employee>empMap = new HashMap<>();
    public void populateMap(List<Employee> employees, int id) {
        if(employees.size() ==0)
            return;
        for(int i =0; i <employees.size();i++)
        {
            empMap.put(employees.get(i).id,employees.get(i));
        }
    }
    public int getImportance( int id) {

       if(empMap.containsKey(id))
       {
           imp = imp+empMap.get(id).importance;
           for(int subId: empMap.get(id).subordinates)
           {
               getImportance(subId);
           }
       }
        return 0;
    }
}
