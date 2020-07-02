//package com.practice.ds;
//import java.util.*;
//public class ComparableComparators {
//    static class Employee implements Comparable{
//        int eid;
//        int salary;
//        Employee(int eid,int salary)
//        {
//            this.eid=eid;
//            this.salary=salary;
//        }
//
//        @Override
//        public String toString() {
//            return "Employee{" +
//                    "eid=" + eid +
//                    ", salary=" + salary +
//                    '}';
//        }
//
//        @Override
//        public int compareTo(Object o) {
//            Employee e2 = (Employee)o;
//            if(this.eid == e2.eid)
//                return 0;
//            if(this.eid>e2.eid)
//                return 1;
//            else
//                return -1;
//        }
//    }
//
//    public static void main(String[] args) {
//        Random random = new Random();
//        List<Employee>list = new ArrayList<>();
//        for(int i =1; i <10;i++)
//        {
//            list.add(new Employee(i,random.nextInt(10000)));
//        }
//        Collections.sort(list);
//        System.out.println(list);
//        Comparator<Employee>c = new Comparator<Employee>(){
//
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                if(o1.salary == o2.salary)
//                    return 0;
//                if(o1.salary>o2.salary)
//                    return 1;
//                else
//                    return -1;
//            }
//        };
//        Collections.sort(list,c);
//        System.out.println(list);
//    }
//}
